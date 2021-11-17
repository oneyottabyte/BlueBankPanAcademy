package br.com.pan.bluebank.mappers;

import br.com.pan.bluebank.Utils.Utils;
import br.com.pan.bluebank.dto.ClienteDTO;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Endereco;
import java.time.LocalDate;


public class ClienteMapper {
	
	public static Cliente toEntity(ClienteDTO dto) {		
		return new Cliente(dto.getNome(),
				dto.getCpf(),
                                Utils.toLocalDate(dto.getDataNascimento()),
				dto.getEmail(),
				dto.getTelefone(),
				dto.getEndereco());
	}

	public static Cliente updateEntity(Cliente cliente, ClienteDTO dto) {
		Cliente oldClient = cliente;
		
                
                LocalDate dataDeNascimento = (dto.getDataNascimento() != null) ? 
                Utils.toLocalDate(dto.getDataNascimento()) : oldClient.getDataNascimento();
                
		cliente.setDataNascimento(dataDeNascimento);
		cliente.setEmail(dto.getEmail() != null ? dto.getEmail() : oldClient.getEmail());						
		cliente.setNome(dto.getNome() != null ? dto.getNome() : oldClient.getNome());
		cliente.setTelefone(dto.getTelefone() != null ? dto.getTelefone() : oldClient.getTelefone());
		cliente.setEndereco(dto.getEndereco());		
		return cliente;
	}
}
