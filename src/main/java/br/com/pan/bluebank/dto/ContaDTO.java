package br.com.pan.bluebank.dto;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.pan.bluebank.model.ENUM.TipoDeConta;

public class ContaDTO {
	

    private String numeroDaConta;
    private BigDecimal saldo;
    private TipoDeConta tipoDeConta;
    private Long idAgencia;
    private Long idCliente;
	
    public ContaDTO() {
	}

	public ContaDTO(String numeroDaConta, BigDecimal saldo, TipoDeConta tipoDeConta,
			Long idAgencia, Long idCliente) {
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.tipoDeConta = tipoDeConta;
		this.idAgencia = idAgencia;
		this.idCliente = idCliente;
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

	public TipoDeConta getTipoDeConta() {
		return tipoDeConta;
	}

	public void setTipoDeConta(TipoDeConta tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}

	public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDaConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaDTO other = (ContaDTO) obj;
		return Objects.equals(numeroDaConta, other.numeroDaConta);
	} 

}
