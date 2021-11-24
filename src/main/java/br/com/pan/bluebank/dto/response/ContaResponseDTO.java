package br.com.pan.bluebank.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.pan.bluebank.model.enums.StatusDeConta;
import br.com.pan.bluebank.model.enums.TipoDeConta;
import io.swagger.annotations.ApiModelProperty;

public class ContaResponseDTO {

    private Long id;
	private String numeroDaConta;
    private BigDecimal saldo;
    
    @ApiModelProperty(value = "Data de abertura da conta", dataType = "java.sql.LocalDateTime")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDateTime dataAbertura;
    
    private TipoDeConta tipoDeConta;
    private StatusDeConta statusDeConta;
    private String numeroAgencia;
    private String nomeCliente;
	
    public ContaResponseDTO() {
	}

	

	public ContaResponseDTO(Long id, String numeroDaConta, BigDecimal saldo, LocalDateTime dataAbertura,
			TipoDeConta tipoDeConta, StatusDeConta statusDeConta, String numeroAgencia, String nomeCliente) {
		this.id = id;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
		this.tipoDeConta = tipoDeConta;
		this.statusDeConta = statusDeConta;
		this.numeroAgencia = numeroAgencia;
		this.nomeCliente = nomeCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	
	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}



	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
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
	
	public StatusDeConta getStatusDeConta() {
		return statusDeConta;
	}

	public void setStatusDeConta(StatusDeConta statusDeConta) {
		this.statusDeConta = statusDeConta;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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
		ContaResponseDTO other = (ContaResponseDTO) obj;
		return Objects.equals(numeroDaConta, other.numeroDaConta);
	}
    
    
}
