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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tb_agencias")
public class Agencia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
    private Long id;
    
    @Pattern(regexp = "/^[0-9]+$/")
    @NotBlank(message = "Número da agência é um atributo obrigatório!")   
    @Column(name = "numero_agencia")
    private String numeroAgencia;
    
    @Pattern(regexp = "/^[A-Za-z]+$/")
    @NotBlank(message = "Nome da agência é um atributo obrigatório!")   
    @Column(name = "nome_agencia")
    private String nomeAgencia;
    
    @JoinColumn(name = "id_Gerente")
    @OneToOne
    private Gerente gerente;
    
    
    public Agencia() {
    }

	public Agencia(
			@Pattern(regexp = "/^[0-9]+$/") @NotBlank(message = "Número da agência é um atributo obrigatório!") String numeroAgencia,
			@Pattern(regexp = "/^[A-Za-z]+$/") @NotBlank(message = "Nome da agência é um atributo obrigatório!") String nomeAgencia,
			Gerente gerente) {
		super();
		this.numeroAgencia = numeroAgencia;
		this.nomeAgencia = nomeAgencia;
		this.gerente = gerente;
	}



	public Agencia(
			@Pattern(regexp = "/^[0-9]+$/") @NotBlank(message = "Número da agência é um atributo obrigatório!") String numeroAgencia,
			@Pattern(regexp = "/^[A-Za-z]+$/") @NotBlank(message = "Nome da agência é um atributo obrigatório!") String nomeAgencia) {
		super();
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
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
    
    
	

}
