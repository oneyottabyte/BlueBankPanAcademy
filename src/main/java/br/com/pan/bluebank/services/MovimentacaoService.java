package br.com.pan.bluebank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dto.MovimentacaoDTO;
import br.com.pan.bluebank.dto.response.MovimentacaoResponseDTO;
import br.com.pan.bluebank.mappers.MovimentacaoMapper;
import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.model.Movimentacao;
import br.com.pan.bluebank.model.enums.TipoMovimentacao;
import br.com.pan.bluebank.repositories.MovimentacaoRepository;
import br.com.pan.bluebank.services.exceptions.ResourceNotFoundException;

@Service
public class MovimentacaoService {

	@Autowired
	private ContaService contaService;

	@Autowired
	public MovimentacaoRepository movimentacaoRepository;

	public Movimentacao create(MovimentacaoDTO dto) {		
		Movimentacao movimentacao = criaMovimentacao(dto);
		movimentacao = atualizaSaldoContasPorTipo(TipoMovimentacao.valueOf(dto.getTipo()), movimentacao);
		salvaContasMovimentacaoPorTipo(TipoMovimentacao.valueOf(dto.getTipo()), movimentacao);
		return movimentacaoRepository.save(movimentacao);
	}

	@Transactional
	public Movimentacao findById(Long id) {
		return movimentacaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movimentação não encontrada!"));
	}
	
	@Transactional
	public MovimentacaoResponseDTO findByIdResponse(Long id) {
		Movimentacao movimentacao = findById(id);			
								
		return MovimentacaoMapper.toResponseDTO(movimentacao);
	}

	public Page<MovimentacaoResponseDTO> findAll(Pageable page) {
		return movimentacaoRepository.findAll(page)							
							.map(movimentacacao -> MovimentacaoMapper.toResponseDTO(movimentacacao));
	}

	private void salvaContasMovimentacaoPorTipo(TipoMovimentacao tipoMovimentacao, Movimentacao movimentacaoAtt) {
		if (tipoMovimentacao.possuiContaDestino()) {
			contaService.atualizarConta(movimentacaoAtt.getContaOrigem());
			contaService.atualizarConta(movimentacaoAtt.getContaDestino());
		} else {
			contaService.atualizarConta(movimentacaoAtt.getContaOrigem());
		}
	}

	private Movimentacao criaMovimentacao(MovimentacaoDTO dto) {
		
		try {
			Conta contaBase = contaService.findById(dto.getContaOrigemId(), "Conta origem não encontrada!");
			if (TipoMovimentacao.valueOf(dto.getTipo()).possuiContaDestino()) {
				Conta contaDestino = contaService.findById(dto.getContaDestinoId(), "Conta destino não encontrada!");
				return MovimentacaoMapper.toEntity(dto, contaBase, contaDestino);
			} else {
				return MovimentacaoMapper.toEntity(dto, contaBase, contaBase);
			}
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Tipo de movimentação inválido!");
		} 

	}

	private Movimentacao atualizaSaldoContasPorTipo(TipoMovimentacao tipo, Movimentacao movimentacao) {
		return tipo.atualizaSaldo(movimentacao);
	}
	
}
