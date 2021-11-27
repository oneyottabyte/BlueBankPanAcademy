package br.com.pan.bluebank.dto;

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

