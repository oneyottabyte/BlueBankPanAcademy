package br.com.pan.bluebank.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.pan.bluebank.model.enums.TipoMovimentacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtratoFilter {
	
	private Long contaId;
	
    private TipoMovimentacao tipo;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataMovimentacao;
 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime initialDataMovimentacao;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finalDataMovimentacao;

}