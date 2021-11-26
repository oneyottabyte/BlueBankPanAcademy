package br.com.pan.bluebank.dto.response;

import java.util.Objects;

public class AgenciaResponseDTO {
	private String numeroAgencia;
	private String nomeAgencia;
	private String nomeGerente;
	
	public AgenciaResponseDTO() {
		
	}

	public AgenciaResponseDTO(String numeroAgencia, String nomeAgencia, String nomeGerente) {
		this.numeroAgencia = numeroAgencia;
		this.nomeAgencia = nomeAgencia;
		this.nomeGerente = nomeGerente;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public String getNomeGerente() {
		return nomeGerente;
	}

	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroAgencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgenciaResponseDTO other = (AgenciaResponseDTO) obj;
		return Objects.equals(numeroAgencia, other.numeroAgencia);
	}
}
