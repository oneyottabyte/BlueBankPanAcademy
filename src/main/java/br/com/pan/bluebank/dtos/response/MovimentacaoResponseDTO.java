package br.com.pan.bluebank.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoResponseDTO {
	
	private Long id;     	
    private String tipo;
    private BigDecimal valorTransacao;    
    private Long contaOrigemId;   
    private String nomeClienteContaOrigem;
    private Long contaDestinoId;
    private String nomeClienteContaDestino;
    
    @ApiModelProperty(value = "Data da criação da movimentação", dataType = "java.sql.LocalDateTime")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataMovimentacao;
   
}
