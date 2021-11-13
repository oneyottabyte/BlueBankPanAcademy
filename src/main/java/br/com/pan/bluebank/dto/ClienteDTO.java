package br.com.pan.bluebank.dto;

import java.time.LocalDate;

import br.com.pan.bluebank.model.Endereco;

public class ClienteDTO {
	
	private String nome;	
	private String cpf;
	private LocalDate dataNascimento;
	private String email;
	private String telefone;
		
	private Endereco endereco;
			
	public ClienteDTO() {
	
	}	

	public ClienteDTO(String nome, LocalDate dataNascimento, String email, String telefone, Endereco endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	
}
