
package br.com.pan.bluebank.models;

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

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.pan.bluebank.model.enums.TipoMovimentacao;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
	@ApiModelProperty(value = "Data da movimentação" , dataType = "java.sql.LocalDateTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataMovimentacao;
    
    @JoinColumn(name = "id_conta_origem")
    @ManyToOne(optional = false)
	@ApiModelProperty(value = "Conta de origem da movimentação")
    private Conta contaOrigem;   
    
    @JoinColumn(name = "id_conta_destino")
    @ManyToOne(optional = false)
	@ApiModelProperty(value = "Conta de destino da movimentação")
    private Conta contaDestino;
       
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
}
