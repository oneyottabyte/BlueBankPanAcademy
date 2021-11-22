package br.com.pan.bluebank.dto;

import java.math.BigDecimal;

public class MovimentacaoDTO {
	
	private Long id;     	
    private String tipo;
    private BigDecimal valorTransacao;    
    private Long contaOrigemId;    
    private Long contaDestinoId;
    
	public MovimentacaoDTO() {
	
	}	

	public MovimentacaoDTO(Long id, String tipo, BigDecimal valorTransacao, Long contaOrigemId,
			Long contaDestinoId) {	
		this.id = id;
		this.tipo = tipo;
		this.valorTransacao = valorTransacao;
		this.contaOrigemId = contaOrigemId;
		this.contaDestinoId = contaDestinoId;
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

	public Long getContaDestinoId() {
		return contaDestinoId;
	}

	public void setContaDestinoId(Long contaDestinoId) {
		this.contaDestinoId = contaDestinoId;
	}    
	
}
