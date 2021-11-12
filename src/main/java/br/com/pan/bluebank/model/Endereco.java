package br.com.pan.bluebank.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_enderecos")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;
    
    @NotBlank(message = "Logradouro é um atributo obrigatório")
    @Size(min = 1, max = 100)
    @Column(name = "logradouro")
    private String logradouro;
    
    @NotBlank(message = "Número é um atributo obrigatório")
    @Size(min = 1, max = 10)
    @Column(name = "numero")
    private String numero;
    
    @NotBlank(message = "CEP é um atributo obrigatório")
    @Size(min = 1, max = 10)
    @Column(name = "cep")
    private String cep;
    
    @Size(max = 45)
    @Column(name = "bairro")
    private String bairro;
    
    @Size(max = 100)
    @Column(name = "complemento")
    private String complemento;
    
    @JoinColumn(name = "id_cidade")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;

    public Endereco() {
    }

	public Endereco(
			@NotBlank(message = "Logradouro é um atributo obrigatório") @Size(min = 1, max = 100) String logradouro,
			@NotBlank(message = "Número é um atributo obrigatório") @Size(min = 1, max = 10) String numero,
			@NotBlank(message = "CEP é um atributo obrigatório") @Size(min = 1, max = 10) String cep,
			@Size(max = 45) String bairro, @Size(max = 100) String complemento, Cidade cidade) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

}