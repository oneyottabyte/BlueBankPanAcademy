package br.com.pan.bluebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_enderecos")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
	@ApiModelProperty(value = "Código do endereço")
    private Long id;
    
    @NotBlank(message = "Logradouro é um atributo obrigatório")
    @Size(min = 1, max = 100)
    @Column(name = "logradouro")
	@ApiModelProperty(value = "Nome do logradouro do endereço")
    private String logradouro;
    
    @NotBlank(message = "Número é um atributo obrigatório")
    @Size(min = 1, max = 10)
    @Column(name = "numero")
	@ApiModelProperty(value = "Número do endereço")
    private String numero;
    
    @NotBlank(message = "CEP é um atributo obrigatório")
    @Size(min = 1, max = 10)
    @Column(name = "cep")
	@ApiModelProperty(value = "CEP do endereço")
    private String cep;
    
    @Size(max = 45)
    @Column(name = "bairro")
	@ApiModelProperty(value = "Bairro do endereço")
    private String bairro;
    
    @Size(max = 100)
    @Column(name = "complemento")
	@ApiModelProperty(value = "Complemento do endereço")
    private String complemento;
    
    @NotBlank(message = "Cidade é um atributo obrigatório")
    @Size(max = 100)
    @Column(name = "cidade")
	@ApiModelProperty(value = "Cidade do endereço")
    private String cidade;
    
    @NotBlank(message = "Estado é um atributo obrigatório")
    @Size(max = 100)    
    @Column(name = "estado")
	@ApiModelProperty(value = "Estado do endereço")
    private String estado;
   
	public Endereco(
			@NotBlank(message = "Logradouro é um atributo obrigatório") @Size(min = 1, max = 100) String logradouro,
			@NotBlank(message = "Número é um atributo obrigatório") @Size(min = 1, max = 10) String numero,
			@NotBlank(message = "CEP é um atributo obrigatório") @Size(min = 1, max = 10) String cep,
			@Size(max = 45) String bairro, @Size(max = 100) String complemento,
			@NotBlank(message = "Cidade é um atributo obrigatório") @Size(max = 100) String cidade,
			@NotBlank(message = "Estado é um atributo obrigatório") @Size(max = 100) String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}

}