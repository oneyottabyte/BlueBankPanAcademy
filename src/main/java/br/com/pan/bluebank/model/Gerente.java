package br.com.pan.bluebank.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_gerentes")
public class Gerente implements Serializable {

	static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gerente")
	@ApiModelProperty(value = "Código do gerente")
	private Long id;

	@NotBlank(message = "Nome é um atributo obrigatório")
	@Pattern(regexp = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}", message = "Nome inválido")
	@Column(name = "nome")
	@ApiModelProperty(value = "Nome do gerente")
	private String nome;

	@NotBlank(message = "CPF é um atributo obrigatório")
	@CPF
	@Column(name = "cpf", unique = true)
	@ApiModelProperty(value = "CPF do gerente")
	private String cpf;

	@NotBlank(message = "E-mail é um atributo obrigatório")
	@Email
	@Column(name = "email", unique = true)
	@ApiModelProperty(value = "Email do gerente")
	private String email;
	
	@NotBlank(message = "Telefone é um atributo obrigatório") 
	@Column(name = "telefone", unique = true)
	@ApiModelProperty(value = "Telefone do gerente")
	private String telefone;

	@NotNull(message = "Endereço é um atributo obrigatório")
	@OneToOne
	@JoinColumn(name = "id_endereco")
	@ApiModelProperty(value = "Endereço do gerente")
	private Endereco endereco;

	public Gerente() {
	}

	public Gerente(
			@NotBlank(message = "Nome é um atributo obrigatório") @Pattern(regexp = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}", message = "Nome inválido") String nome,
			@NotBlank(message = "CPF é um atributo obrigatório") @CPF String cpf,
			@NotBlank(message = "E-mail é um atributo obrigatório") @Email String email,
			@NotBlank(message = "Telefone é um atributo obrigatório") String telefone,
			@NotNull(message = "Endereço é um atributo obrigatório") Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Gerente(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public Long getId() {
		return id;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gerente other = (Gerente) obj;
		return Objects.equals(id, other.id);
	}
}
