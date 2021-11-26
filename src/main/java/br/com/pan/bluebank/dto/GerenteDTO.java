package br.com.pan.bluebank.dto;

import java.util.Objects;

import br.com.pan.bluebank.model.Agencia;
import br.com.pan.bluebank.model.Endereco;

public class GerenteDTO {
	
	private String nome;	
	private String cpf;
	private String email;
	private String telefone;
	private Endereco endereco;
	private Agencia agencia;
			
	public GerenteDTO() {
	
	}	
	
	public GerenteDTO(String nome, String cpf, String email, String telefone, Endereco endereco, Agencia agencia) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.agencia = agencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GerenteDTO other = (GerenteDTO) obj;
		return Objects.equals(cpf, other.cpf);
	}	
}
