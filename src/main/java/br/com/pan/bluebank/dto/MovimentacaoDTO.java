package br.com.pan.bluebank.dto;

import java.math.BigDecimal;

import br.com.pan.bluebank.model.ENUM.TipoMovimentacao;

public class MovimentacaoDTO {
	
	private Long id;     

    private TipoMovimentacao tipo;

    private BigDecimal valorTransacao;
    
	public MovimentacaoDTO() {
	
	}

	public MovimentacaoDTO(Long id, TipoMovimentacao tipo, BigDecimal valorTransacao) {
		this.id = id;
		this.tipo = tipo;
		this.valorTransacao = valorTransacao;
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

}
