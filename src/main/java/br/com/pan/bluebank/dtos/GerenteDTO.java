package br.com.pan.bluebank.dtos;

import br.com.pan.bluebank.model.Agencia;
import br.com.pan.bluebank.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GerenteDTO {
	
	private String nome;	
	private String cpf;
	private String email;
	private String telefone;
	private Endereco endereco;
	private Agencia agencia;

}
