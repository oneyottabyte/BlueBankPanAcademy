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
import br.com.pan.bluebank.repositories.ContaRepository;
import br.com.pan.bluebank.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired 
	public MovimentacaoRepository movimentacaoRepository;
			
	public Movimentacao create(Long origemId, Long destinoId, MovimentacaoDTO dto) {	
		Conta contaOrigem = contaRepository.findById(origemId).orElseThrow();
		Conta contaDestino = contaRepository.findById(destinoId).orElseThrow();
		
		if(contaOrigem.getSaldo().compareTo(dto.getValorTransacao()) >= 0) {
			contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(dto.getValorTransacao()));
			contaDestino.setSaldo(contaDestino.getSaldo().add(dto.getValorTransacao()));
		} else {
			throw new Error();
		}
				
		contaRepository.save(contaOrigem);
		contaRepository.save(contaDestino);
		Movimentacao save = movimentacaoRepository.save(MovimentacaoMapper.toEntity(dto, contaOrigem, contaDestino));
		
		return save;	
	}
		
	@Transactional
	public Movimentacao findById(Long id) {	
		return movimentacaoRepository.findById(id).orElseThrow();
	}
	
	public Page<Movimentacao> findAll(Pageable page) {
		return movimentacaoRepository.findAll(page);
	}	

}
