package br.com.pan.bluebank.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class MovimentacaoResponseDTO {
	
	private Long id;     	
    private String tipo;
    private BigDecimal valorTransacao;    
    private Long contaOrigemId;   
    private String nomeClienteContaOrigem;
    private Long contaDestinoId;
    private String nomeClienteContaDestino;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDateTime dataMovimentacao;
    
	public MovimentacaoResponseDTO() {
	
	}

	public MovimentacaoResponseDTO(Long id, String tipo, BigDecimal valorTransacao, Long contaOrigemId,
			String nomeClienteContaOrigem, Long contaDestinoId, String nomeClienteContaDestino,
			LocalDateTime dataMovimentacao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valorTransacao = valorTransacao;
		this.contaOrigemId = contaOrigemId;
		this.nomeClienteContaOrigem = nomeClienteContaOrigem;
		this.contaDestinoId = contaDestinoId;
		this.nomeClienteContaDestino = nomeClienteContaDestino;
		this.dataMovimentacao = dataMovimentacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public Long getContaOrigemId() {
		return contaOrigemId;
	}

	public void setContaOrigemId(Long contaOrigemId) {
		this.contaOrigemId = contaOrigemId;
	}

	public String getNomeClienteContaOrigem() {
		return nomeClienteContaOrigem;
	}

	public void setNomeClienteContaOrigem(String nomeClienteContaOrigem) {
		this.nomeClienteContaOrigem = nomeClienteContaOrigem;
	}

	public Long getContaDestinoId() {
		return contaDestinoId;
	}

	public void setContaDestinoId(Long contaDestinoId) {
		this.contaDestinoId = contaDestinoId;
	}

	public String getNomeClienteContaDestino() {
		return nomeClienteContaDestino;
	}

	public void setNomeClienteContaDestino(String nomeClienteContaDestino) {
		this.nomeClienteContaDestino = nomeClienteContaDestino;
	}

	public LocalDateTime getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}	
	
}
