package br.com.pan.bluebank.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenciaResponseDTO {
	
	private String numeroAgencia;
	private String nomeAgencia;
	private String nomeGerente;
	
}
