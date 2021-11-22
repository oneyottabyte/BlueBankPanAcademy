
package br.com.pan.bluebank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.pan.bluebank.model.enums.TipoMovimentacao;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_movimentacoes")
public class Movimentacao implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimentacao")
	@ApiModelProperty(value = "Código da movimentação")
    private Long id;     
    
    @NotNull(message = "Tipo de movimentação é um atributo obrigatório!")   
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Tipo da movimentação")
    private TipoMovimentacao tipo;
        
    @Positive(message = "O valor da transação tem de ser positivo")
    @NotNull(message = "Valor é um atributo obrigatório!") 
    @Column(name = "valor_transacao")
	@ApiModelProperty(value = "Valor da movimentação")
    private BigDecimal valorTransacao;    

    @Column(name = "data_movimentacao")
	@ApiModelProperty(value = "Data da movimentação")
    private LocalDateTime dataMovimentacao;
    
    @JoinColumn(name = "id_conta_origem")
    @ManyToOne(optional = false)
	@ApiModelProperty(value = "Conta de origem da movimentação")
    private Conta contaOrigem;   
    
    @JoinColumn(name = "id_conta_destino")
    @ManyToOne(optional = false)
	@ApiModelProperty(value = "Conta de destino da movimentação")
    private Conta contaDestino;
       
    public Movimentacao() {
    }

	public Movimentacao(
			@NotBlank(message = "Tipo de movimentação é um atributo obrigatório!") TipoMovimentacao tipo,
			@Positive(message = "O valor da transação tem de ser positivo") @NotBlank(message = "Valor é um atributo obrigatório!") BigDecimal valorTransacao,
			LocalDateTime dataMovimentacao, Conta contaOrigem, Conta contaDestino) {
		this.tipo = tipo;
		this.valorTransacao = valorTransacao;
		this.dataMovimentacao = dataMovimentacao;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
	}
	
	public Long getId() {
		return id;
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

	public LocalDateTime getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}    
	
}
