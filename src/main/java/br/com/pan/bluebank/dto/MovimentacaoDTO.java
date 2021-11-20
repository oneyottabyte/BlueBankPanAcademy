package br.com.pan.bluebank.dto;

import java.math.BigDecimal;

import br.com.pan.bluebank.model.enums.TipoMovimentacao;

public class MovimentacaoDTO {
	
	private Long id;     

    private TipoMovimentacao tipo;

    private BigDecimal valorTransacao;
    
    private Long contaOrigemId;
    
    private Long contaDestinoId;
    
	public MovimentacaoDTO() {
	
	}	

	public MovimentacaoDTO(Long id, TipoMovimentacao tipo, BigDecimal valorTransacao, Long contaOrigemId,
			Long contaDestinoId) {
		super();
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

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
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
