package br.com.pan.bluebank.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDTO {
	
	private Long id;     	
    private String tipo;
    private BigDecimal valorTransacao;    
    private Long contaOrigemId;    
    private Long contaDestinoId;
      
}
