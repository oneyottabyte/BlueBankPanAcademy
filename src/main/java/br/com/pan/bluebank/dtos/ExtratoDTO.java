package br.com.pan.bluebank.dtos;

import java.math.BigDecimal;
import java.util.List;

import br.com.pan.bluebank.dtos.response.MovimentacaoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtratoDTO {	

	private BigDecimal valorTotalMovimentacoes;
	private List<MovimentacaoResponseDTO> movimentacoes;
}
