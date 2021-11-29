package br.com.pan.bluebank.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dto.ExtratoDTO;
import br.com.pan.bluebank.dto.ExtratoFilter;
import br.com.pan.bluebank.dto.response.MovimentacaoResponseDTO;
import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.model.enums.TipoMovimentacao;

@Service
public class ExtratoService {
	
	@Autowired
	private MovimentacaoService movimentacaoService;

	public ExtratoDTO geraExtrato(Conta conta, ExtratoFilter filter) {		
		List<MovimentacaoResponseDTO> movimentacoesFiltradas = movimentacaoService.findAllFilter(filter);		
		BigDecimal valorTotal = calculaValorTotal(movimentacoesFiltradas, filter.getContaId());
			
		return new ExtratoDTO(valorTotal, movimentacoesFiltradas);		
	}

	private BigDecimal calculaValorTotal(List<MovimentacaoResponseDTO> movimentacoesFiltradas, Long contaId) {
		BigDecimal total = BigDecimal.ZERO;
		
		for (MovimentacaoResponseDTO movimentacao : movimentacoesFiltradas) {
			if(movimentacao.getTipo().equals(TipoMovimentacao.SAQUE.toString()) ||
			   (movimentacao.getTipo().equals(TipoMovimentacao.TRANSFERENCIA.toString()) && (movimentacao.getContaOrigemId() == contaId))) {
				total = total.subtract(movimentacao.getValorTransacao());
			} else {
				total = total.add(movimentacao.getValorTransacao());
			}
		}		
		return total;
	}
}
