package br.com.pan.bluebank.factories;

import java.math.BigDecimal;

import br.com.pan.bluebank.dtos.MovimentacaoDTO;

public class MovimentacaoFactory {

	public static MovimentacaoDTO createMovimentacaoDTO() {
		
		return new MovimentacaoDTO(1l, "SAQUE", BigDecimal.valueOf(1000), 1L, 1L);
	}

}
