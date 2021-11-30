package br.com.pan.bluebank.mappers;

import br.com.pan.bluebank.dtos.ClienteDTO;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Endereco;
import br.com.pan.bluebank.utils.Utils;

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
		Endereco oldEndereco = cliente.getEndereco();
		Endereco endereco = dto.getEndereco();
		LocalDate dataDeNascimento = (dto.getDataNascimento() != null) ? 
		Utils.toLocalDate(dto.getDataNascimento()) : oldClient.getDataNascimento();           
		cliente.setDataNascimento(dataDeNascimento);
		cliente.setEmail(dto.getEmail() != null ? dto.getEmail() : oldClient.getEmail());						
		cliente.setNome(dto.getNome() != null ? dto.getNome() : oldClient.getNome());
		cliente.setTelefone(dto.getTelefone() != null ? dto.getTelefone() : oldClient.getTelefone());
		endereco.setLogradouro(endereco.getLogradouro() != null ? endereco.getLogradouro() : oldEndereco.getLogradouro());
		endereco.setNumero(endereco.getNumero() != null ? endereco.getNumero() : oldEndereco.getNumero());
		endereco.setComplemento(endereco.getComplemento() != null ? endereco.getComplemento() : oldEndereco.getComplemento());
		endereco.setBairro(endereco.getBairro() != null ? endereco.getBairro() : oldEndereco.getBairro());
		endereco.setCep(endereco.getCep() != null ? endereco.getCep() : oldEndereco.getCep());
		endereco.setCidade(endereco.getCidade() != null ? endereco.getCidade() : oldEndereco.getCidade());
		endereco.setEstado(endereco.getEstado() != null ? endereco.getEstado() : oldEndereco.getEstado());
		cliente.setEndereco(endereco);	
		return cliente;
	}
}
