package br.com.pan.bluebank.factories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pan.bluebank.dtos.ContaDTO;
import br.com.pan.bluebank.model.enums.StatusDeConta;
import br.com.pan.bluebank.model.enums.TipoDeConta;
import br.com.pan.bluebank.models.Agencia;
import br.com.pan.bluebank.models.Cliente;
import br.com.pan.bluebank.models.Conta;

public class ContaFactory {

	public static Conta createConta(Long Id) {
						
		return new Conta(LocalDateTime.now(),
				"12345679-5",
				BigDecimal.ZERO, 
				TipoDeConta.CORRENTE,
				StatusDeConta.ATIVADO,
				new Agencia(),
				new Cliente());
	}
	public static ContaDTO createContaDTO() {		
		return new ContaDTO("12345678-2", TipoDeConta.CORRENTE, 1l, 1l);
	}
}
