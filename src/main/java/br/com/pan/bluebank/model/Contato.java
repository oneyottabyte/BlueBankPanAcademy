package br.com.pan.bluebank.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    private Long id;
        
    @NotBlank(message = "Telefone é um atributo obrigatório!")   
    @Size(min = 1, max = 45)
    @Column(name = "telefone_contato")
    private String telefoneContato;
    
    @JoinColumn(name = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
    
    @JoinColumn(name = "id_gerente")
    @ManyToOne(optional = false)
    private Gerente gerente;

	public Contato() {
		
	}

	public Contato(
			@NotBlank(message = "Telefone é um atributo obrigatório!") @Size(min = 1, max = 45) String telefoneContato,
			Cliente cliente, Gerente gerente) {
		this.telefoneContato = telefoneContato;
		this.cliente = cliente;
		this.gerente = gerente;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

   
}
