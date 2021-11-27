package br.com.pan.bluebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

}
