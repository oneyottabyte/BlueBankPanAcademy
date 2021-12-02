package br.com.pan.bluebank.mappers;

import br.com.pan.bluebank.dtos.GerenteDTO;
import br.com.pan.bluebank.models.Endereco;
import br.com.pan.bluebank.models.Gerente;

public class GerenteMapper {
	
	public static Gerente toEntity(GerenteDTO dto) {		
		return new Gerente(dto.getNome(),
				dto.getCpf(),
				dto.getEmail(),
				dto.getTelefone(),
				dto.getEndereco());
	}

	public static Gerente updateEntity(Gerente gerente, GerenteDTO dto) {
		Gerente oldGerente = gerente; 
		Endereco oldEndereco = gerente.getEndereco();
		Endereco endereco = dto.getEndereco();          
		gerente.setEmail(dto.getEmail() != null ? dto.getEmail() : oldGerente.getEmail());						
		gerente.setNome(dto.getNome() != null ? dto.getNome() : oldGerente.getNome());
		gerente.setTelefone(dto.getTelefone() != null ? dto.getTelefone() : oldGerente.getTelefone());
		endereco.setLogradouro(endereco.getLogradouro() != null ? endereco.getLogradouro() : oldEndereco.getLogradouro());
		endereco.setNumero(endereco.getNumero() != null ? endereco.getNumero() : oldEndereco.getNumero());
		endereco.setComplemento(endereco.getComplemento() != null ? endereco.getComplemento() : oldEndereco.getComplemento());
		endereco.setBairro(endereco.getBairro() != null ? endereco.getBairro() : oldEndereco.getBairro());
		endereco.setCep(endereco.getCep() != null ? endereco.getCep() : oldEndereco.getCep());
		endereco.setCidade(endereco.getCidade() != null ? endereco.getCidade() : oldEndereco.getCidade());
		endereco.setEstado(endereco.getEstado() != null ? endereco.getEstado() : oldEndereco.getEstado());
		gerente.setEndereco(endereco);	
		return gerente;
	}
}
