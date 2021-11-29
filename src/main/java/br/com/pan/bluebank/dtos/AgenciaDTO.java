package br.com.pan.bluebank.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenciaDTO {

	private String numeroAgencia;
	private String nomeAgencia;
	private Long idGerente;

}

