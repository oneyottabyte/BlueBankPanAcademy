package br.com.pan.bluebank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;


import br.com.pan.bluebank.model.ENUM.TipoDeConta;

@Entity
@Table(name = "tb_contas")
public class Conta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private Long id;
	
    @NotNull(message = "Data de abertura é um atributo obrigatório!")
    @Past(message = "Data de abertura inválida")
    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;
	 
    @NotBlank(message = "Número da conta é um atributo obrigatório!")
    @Size(min = 1, max = 10)
    @Column(name = "numero_da_conta", unique = true)
    private String numeroDaConta;
    
    @NotNull(message = "Saldo é um atributo obrigatório!")
    @Column(name = "saldo")
    private BigDecimal saldo;
    
    @NotBlank(message = "Tipo de conta é um atributo obrigatório!")   
    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoDeConta tipoDeConta;
    
    @JoinColumn(name = "id_agencia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Agencia agencia;
    
    @JoinColumn(name = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cliente cliente;
    

	public Conta() {
	}

	
	
	
	public Conta(
			@NotNull(message = "Data de abertura é um atributo obrigatório!") @Past(message = "Data de abertura inválida") LocalDateTime dataAbertura,
			@NotBlank(message = "Número da conta é um atributo obrigatório!") @Size(min = 1, max = 10) String numeroDaConta,
			@NotNull(message = "Saldo é um atributo obrigatório!") BigDecimal saldo,
			@NotBlank(message = "Tipo de conta é um atributo obrigatório!") TipoDeConta tipoDeConta) {
		this.dataAbertura = dataAbertura;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.tipoDeConta = tipoDeConta;
	}

	public Conta(
			@NotBlank(message = "Data de abertura é um atributo obrigatório!") @Past(message = "Data de abertura inválida") LocalDateTime dataAbertura,
			@NotBlank(message = "Número da conta é um atributo obrigatório!") @Size(min = 1, max = 10) String numeroDaConta,
			@NotBlank(message = "Saldo é um atributo obrigatório!") BigDecimal saldo, Agencia agencia, Cliente cliente,
			TipoDeConta tipoDeConta) {
		this.dataAbertura = dataAbertura;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.agencia = agencia;
		this.cliente = cliente;
		this.tipoDeConta = tipoDeConta;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public String getNumeroDaConta() {
		return numeroDaConta;
	}


	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}


	public BigDecimal getSaldo() {
		return saldo;
	}


	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}


	public Agencia getAgencia() {
		return agencia;
	}


	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public TipoDeConta getTipoDeConta() {
		return tipoDeConta;
	}


	public void setTipoDeConta(TipoDeConta tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}


	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(this.id, other.id);
	}
  
}
