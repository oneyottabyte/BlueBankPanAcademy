package br.com.pan.bluebank.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "tb_agencias")
public class Agencia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
	@ApiModelProperty(value = "Código da agência")
    private Long id;
    

    @NotBlank(message = "Número da agência é um atributo obrigatório!")   
    @Column(name = "numero_agencia")
	@ApiModelProperty(value = "Número da agência")
    private String numeroAgencia;
    

    @NotBlank(message = "Nome da agência é um atributo obrigatório!")   
    @Column(name = "nome_agencia")
	@ApiModelProperty(value = "Nome da agência")
    private String nomeAgencia;
    
    @JoinColumn(name = "id_Gerente")
    @OneToOne
	@ApiModelProperty(value = "Gerente da agência")
    private Gerente gerente;
    
    
    public Agencia() {
    }
    
	public Agencia(
			 @NotBlank(message = "Número da agência é um atributo obrigatório!") String numeroAgencia,
			@NotBlank(message = "Nome da agência é um atributo obrigatório!") String nomeAgencia,
			Gerente gerente) {
		this.numeroAgencia = numeroAgencia;
		this.nomeAgencia = nomeAgencia;
		this.gerente = gerente;
	}

	public Agencia(
			 @NotBlank(message = "Número da agência é um atributo obrigatório!") String numeroAgencia,
			@NotBlank(message = "Nome da agência é um atributo obrigatório!") String nomeAgencia) {
		this.numeroAgencia = numeroAgencia;
		this.nomeAgencia = nomeAgencia;
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


	public void setNomeAgencia(String nome) {
		this.nomeAgencia = nome;
	}


	public Gerente getGerente() {
		return gerente;
	}


	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}


	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Agencia other = (Agencia) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}
	
}
