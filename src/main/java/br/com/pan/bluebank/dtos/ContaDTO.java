package br.com.pan.bluebank.dtos;

import br.com.pan.bluebank.models.enums.TipoDeConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {
	
    private String numeroDaConta;
    private TipoDeConta tipoDeConta;
    private Long idAgencia;
    private Long idCliente;
	
}
