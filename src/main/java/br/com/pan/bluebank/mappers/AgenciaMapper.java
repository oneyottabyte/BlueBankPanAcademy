package br.com.pan.bluebank.mappers;

import br.com.pan.bluebank.dtos.response.AgenciaResponseDTO;
import br.com.pan.bluebank.model.Agencia;

public class AgenciaMapper {
		
	public static AgenciaResponseDTO toDTO(Agencia agencia) {
		return new AgenciaResponseDTO(
				agencia.getNumeroAgencia(),
				agencia.getNomeAgencia(),
				agencia.getGerente().getNome());
	}
}
