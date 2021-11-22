package br.com.pan.bluebank.mappers;

import java.time.LocalDateTime;

import br.com.pan.bluebank.dto.MovimentacaoDTO;
import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.model.Movimentacao;
import br.com.pan.bluebank.model.enums.TipoMovimentacao;


public class MovimentacaoMapper {
	
	public static Movimentacao toEntity(MovimentacaoDTO dto, Conta contaOrigem, Conta contaDestino) {
		
		return new Movimentacao(TipoMovimentacao.valueOf(dto.getTipo()),
								dto.getValorTransacao(),
								LocalDateTime.now(),
								contaOrigem,
								contaDestino);
	}
}
