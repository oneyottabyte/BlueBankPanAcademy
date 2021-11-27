package br.com.pan.bluebank.dto;

import br.com.pan.bluebank.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	
	private String nome;	
	private String cpf;
	private String dataNascimento;
	private String email;
	private String telefone;
	private Endereco endereco;
			

}
