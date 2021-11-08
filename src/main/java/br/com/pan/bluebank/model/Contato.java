package br.com.pan.bluebank.model;

public class Contato {
	
	private int idContato;
	private String telefone_contato;
	private Cliente _idCliente;
	
	
	public Contato(int idContato, String telefone_contato, int _idCliente) {
		super();
		this.idContato = idContato;
		this.telefone_contato = telefone_contato;
		this._idCliente = _idCliente;
	}


	public Contato() {
		super();
	}


	public int getIdContato() {
		return idContato;
	}


	public String getTelefone_contato() {
		return telefone_contato;
	}


	public int get_idCliente() {
		return _idCliente;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _idCliente;
		result = prime * result + idContato;
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
		Contato other = (Contato) obj;
		if (_idCliente != other._idCliente)
			return false;
		if (idContato != other.idContato)
			return false;
		return true;
	}

}
