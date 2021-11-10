package br.com.pan.bluebank.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    private Long id;
           
    @NotBlank(message = "Nome da cidade é um atributo obrigatório")
    @Column(name = "nome_cidade")
    private String nomeCidade;
    
    @JoinColumn(name = "id_estado")
    @ManyToOne(optional = false)
    private Estado estado;

	public Cidade() {
	}
	
	public Cidade(@NotBlank(message = "Nome da cidade é um atributo obrigatório") String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Cidade(@NotBlank(message = "Nome da cidade é um atributo obrigatório") String nomeCidade, Estado estado) {
		this.nomeCidade = nomeCidade;
		this.estado = estado;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
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
		Cidade other = (Cidade) obj;
		return Objects.equals(id, other.id);
	}
	
	
 

}
