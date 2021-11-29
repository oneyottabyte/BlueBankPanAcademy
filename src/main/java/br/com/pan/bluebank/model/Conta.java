package br.com.pan.bluebank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.pan.bluebank.model.enums.StatusDeConta;
import br.com.pan.bluebank.model.enums.TipoDeConta;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_contas")
public class Conta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	@ApiModelProperty(value = "Código da conta")
	private Long id;
	
    @NotNull(message = "Data de abertura é um atributo obrigatório!")
    @Past(message = "Data de abertura inválida")
    @Column(name = "data_abertura")
	@ApiModelProperty(value = "Data de abertura da conta", dataType = "java.sql.LocalDateTime")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDateTime dataAbertura;
	 
    @NotBlank(message = "Número da conta é um atributo obrigatório!")
    @Size(min = 1, max = 10)
    @Column(name = "numero_da_conta", unique = true)
	@ApiModelProperty(value = "Número da conta")
    private String numeroDaConta;
    
    @Positive
    @NotNull(message = "Saldo é um atributo obrigatório!")
    @Column(name = "saldo")
	@ApiModelProperty(value = "Saldo da conta")
    private BigDecimal saldo;
    
    @NotNull(message = "Tipo de conta é um atributo obrigatório!")   
    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Tipo da conta")
    private TipoDeConta tipoDeConta;
    
    @NotNull(message = "Status da conta é um atributo obrigatório!")   
    @Column(name = "status_conta")
    @Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Status da conta")
    private StatusDeConta statusDeConta;
    
    @JsonIgnore
    @JoinColumn(name = "id_agencia")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	@ApiModelProperty(value = "Agência da conta")
    private Agencia agencia;
    
    @JsonIgnore
    @JoinColumn(name = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	@ApiModelProperty(value = "Proprietário da conta")
    private Cliente cliente;
    
	public Conta(
			@NotNull(message = "Data de abertura é um atributo obrigatório!") @Past(message = "Data de abertura inválida") LocalDateTime dataAbertura,
			@NotBlank(message = "Número da conta é um atributo obrigatório!") @Size(min = 1, max = 10) String numeroDaConta,
			@NotNull(message = "Saldo é um atributo obrigatório!") BigDecimal saldo,
			@NotNull(message = "Tipo de conta é um atributo obrigatório!") TipoDeConta tipoDeConta,
			@NotNull(message = "Status da conta é um atributo obrigatório!") StatusDeConta statusDeConta) {
		this.dataAbertura = dataAbertura;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.tipoDeConta = tipoDeConta;
		this.statusDeConta = statusDeConta;
	}

	public Conta(
			@NotNull(message = "Data de abertura é um atributo obrigatório!") @Past(message = "Data de abertura inválida") LocalDateTime dataAbertura,
			@NotBlank(message = "Número da conta é um atributo obrigatório!") @Size(min = 1, max = 10) String numeroDaConta,
			@NotNull(message = "Saldo é um atributo obrigatório!") BigDecimal saldo,
			@NotNull(message = "Tipo de conta é um atributo obrigatório!") TipoDeConta tipoDeConta,
			@NotNull(message = "Status da conta é um atributo obrigatório!") StatusDeConta statusDeConta,
			Agencia agencia, Cliente cliente) {
		this.dataAbertura = dataAbertura;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.tipoDeConta = tipoDeConta;
		this.statusDeConta = statusDeConta;
		this.agencia = agencia;
		this.cliente = cliente;
	}
}
