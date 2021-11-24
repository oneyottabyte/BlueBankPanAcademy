package br.com.pan.bluebank.dto.response;

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
	
	
	
}
