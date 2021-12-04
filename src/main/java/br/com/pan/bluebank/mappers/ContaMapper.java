package br.com.pan.bluebank.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pan.bluebank.dtos.ContaDTO;
import br.com.pan.bluebank.dtos.response.ContaResponseDTO;
import br.com.pan.bluebank.models.Agencia;
import br.com.pan.bluebank.models.Cliente;
import br.com.pan.bluebank.models.Conta;
import br.com.pan.bluebank.models.enums.StatusDeConta;

public class ContaMapper {
	
	public static Conta toEntity(ContaDTO dto, Cliente cliente, Agencia agencia) {
		return new Conta(
				LocalDateTime.now(),
				dto.getNumeroDaConta(),
				BigDecimal.ZERO,
				dto.getTipoDeConta(),
				StatusDeConta.ATIVADO,
				agencia,
				cliente);
	}
	
	public static ContaResponseDTO toDTO(Conta conta) {
		return new ContaResponseDTO(
				conta.getId(),
				conta.getNumeroDaConta(),
				conta.getSaldo(),
				conta.getDataAbertura(),
				conta.getTipoDeConta(),
				conta.getStatusDeConta(),
				conta.getAgencia().getNumeroAgencia(),
				conta.getCliente().getNome());
	}
}
