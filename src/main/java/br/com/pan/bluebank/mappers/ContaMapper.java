package br.com.pan.bluebank.mappers;

import java.time.LocalDateTime;

import br.com.pan.bluebank.dto.ContaDTO;
import br.com.pan.bluebank.model.Agencia;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Conta;

public class ContaMapper {
	
	public static Conta toEntity(ContaDTO dto, Cliente cliente, Agencia agencia) {
		return new Conta(
				LocalDateTime.now(),
				dto.getNumeroDaConta(),
				dto.getSaldo(),
				agencia,
				cliente,
				dto.getTipoDeConta());
	}

}
