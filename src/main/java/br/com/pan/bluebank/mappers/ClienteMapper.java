package br.com.pan.bluebank.mappers;

import br.com.pan.bluebank.dto.ClienteDTO;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Endereco;


public class ClienteMapper {
	
	public static Cliente toEntity(ClienteDTO dto) {		
		return new Cliente(dto.getNome(),
				dto.getCpf(),
				dto.getDataNascimento(),
				dto.getEmail(),
				dto.getTelefone(),
				dto.getEndereco());
	}

	public static Cliente updateEntity(Cliente cliente, ClienteDTO dto) {
		Cliente oldClient = cliente;
		
		cliente.setDataNascimento(dto.getDataNascimento() != null ? dto.getDataNascimento() : oldClient.getDataNascimento());
		cliente.setEmail(dto.getEmail() != null ? dto.getEmail() : oldClient.getEmail());						
		cliente.setNome(dto.getNome() != null ? dto.getNome() : oldClient.getNome());
		cliente.setTelefone(dto.getTelefone() != null ? dto.getTelefone() : oldClient.getTelefone());
		cliente.setEndereco(dto.getEndereco());		
		return cliente;
	}
}
