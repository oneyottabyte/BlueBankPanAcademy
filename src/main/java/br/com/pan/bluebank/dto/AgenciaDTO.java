package br.com.pan.bluebank.dto;

public class AgenciaDTO {

	private String numeroAgencia;
	private String nomeAgencia;
	private Long idGerente;

	public AgenciaDTO() {

	}

	public AgenciaDTO(String numeroAgencia, String nomeAgencia, Long idGerente) {
		this.numeroAgencia = numeroAgencia;
		this.nomeAgencia = nomeAgencia;
		this.idGerente = idGerente;
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

	public Long getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(Long idGerente) {
		this.idGerente = idGerente;
	}	
}

