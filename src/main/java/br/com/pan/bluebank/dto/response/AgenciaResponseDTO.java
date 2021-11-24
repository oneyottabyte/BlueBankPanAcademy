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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeAgencia == null) ? 0 : nomeAgencia.hashCode());
		result = prime * result + ((nomeGerente == null) ? 0 : nomeGerente.hashCode());
		result = prime * result + ((numeroAgencia == null) ? 0 : numeroAgencia.hashCode());
		return result;
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
		if (nomeAgencia == null) {
			if (other.nomeAgencia != null)
				return false;
		} else if (!nomeAgencia.equals(other.nomeAgencia))
			return false;
		if (nomeGerente == null) {
			if (other.nomeGerente != null)
				return false;
		} else if (!nomeGerente.equals(other.nomeGerente))
			return false;
		if (numeroAgencia == null) {
			if (other.numeroAgencia != null)
				return false;
		} else if (!numeroAgencia.equals(other.numeroAgencia))
			return false;
		return true;
	}
	
}
