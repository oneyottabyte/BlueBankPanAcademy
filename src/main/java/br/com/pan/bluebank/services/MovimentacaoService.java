package br.com.pan.bluebank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dto.MovimentacaoDTO;
import br.com.pan.bluebank.mappers.MovimentacaoMapper;
import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.model.Movimentacao;
import br.com.pan.bluebank.model.enums.TipoMovimentacao;
import br.com.pan.bluebank.repositories.ContaRepository;
import br.com.pan.bluebank.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired 
	public MovimentacaoRepository movimentacaoRepository;
			
	public Movimentacao create(MovimentacaoDTO dto) {	
		Movimentacao movimentacao = criaMovimentacao(dto);		
		
		movimentacao = atualizaSaldoContasPorTipo(dto.getTipo(), movimentacao); ;
							
		salvaContasMovimentacaoPorTipo(dto.getTipo(), movimentacao);		
				
		return movimentacaoRepository.save(movimentacao);	
	}		

	@Transactional
	public Movimentacao findById(Long id) {	
		return movimentacaoRepository.findById(id).orElseThrow();
	}
	
	public Page<Movimentacao> findAll(Pageable page) {
		return movimentacaoRepository.findAll(page);
	}	
		
	private void salvaContasMovimentacaoPorTipo(TipoMovimentacao tipoMovimentacao, Movimentacao movimentacaoAtt) {
		if(tipoMovimentacao.possuiContaDestino()) {
			contaRepository.save(movimentacaoAtt.getContaOrigem());
			contaRepository.save(movimentacaoAtt.getContaDestino());
		} else {
			contaRepository.save(movimentacaoAtt.getContaOrigem());
		}		
	}

	private Movimentacao criaMovimentacao(MovimentacaoDTO dto) {
		Conta contaBase = contaRepository.findById(dto.getContaOrigemId()).orElseThrow();		
		if(dto.getTipo().possuiContaDestino()) {
			Conta contaDestino = contaRepository.findById(dto.getContaDestinoId()).orElseThrow();			
			return MovimentacaoMapper.toEntity(dto, contaBase, contaDestino);
		} else {
			return MovimentacaoMapper.toEntity(dto, contaBase, contaBase);
		}		 
	}

	private Movimentacao atualizaSaldoContasPorTipo(TipoMovimentacao tipo, Movimentacao movimentacao) {		
		return tipo.atualizaSaldo(movimentacao);
	}
}
