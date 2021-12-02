package br.com.pan.bluebank.mappers;

import java.time.LocalDateTime;

import br.com.pan.bluebank.dtos.MovimentacaoDTO;
import br.com.pan.bluebank.dtos.response.MovimentacaoResponseDTO;
import br.com.pan.bluebank.model.enums.TipoMovimentacao;
import br.com.pan.bluebank.models.Conta;
import br.com.pan.bluebank.models.Movimentacao;


public class MovimentacaoMapper {
	
	public static Movimentacao toEntity(MovimentacaoDTO dto, Conta contaOrigem, Conta contaDestino) {
		
		return new Movimentacao(TipoMovimentacao.valueOf(dto.getTipo()),
								dto.getValorTransacao(),
								LocalDateTime.now(),
								contaOrigem,
								contaDestino);
	}

	public static MovimentacaoResponseDTO toResponseDTO(Movimentacao movimentacao) {
		
		return new MovimentacaoResponseDTO(
				movimentacao.getId(),
				movimentacao.getTipo().toString(),
				movimentacao.getValorTransacao(),
				movimentacao.getContaOrigem().getId(),
				movimentacao.getContaOrigem().getCliente().getNome(),
				movimentacao.getContaDestino().getId(),
				movimentacao.getContaDestino().getCliente().getNome(),
				movimentacao.getDataMovimentacao()
											);
	}
}
