package br.com.pan.bluebank.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.pan.bluebank.model.enums.StatusDeConta;
import br.com.pan.bluebank.model.enums.TipoDeConta;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponseDTO {

    private Long id;
	private String numeroDaConta;
    private BigDecimal saldo;
    
    @ApiModelProperty(value = "Data de abertura da conta", dataType = "java.sql.LocalDateTime")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDateTime dataAbertura;
    
    private TipoDeConta tipoDeConta;
    private StatusDeConta statusDeConta;
    private String numeroAgencia;
    private String nomeCliente;
 
}
