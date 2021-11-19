package br.com.pan.bluebank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.pan.bluebank.model.Endereco;
import br.com.pan.bluebank.model.Gerente;
import br.com.pan.bluebank.repositories.GerenteRepository;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository gerenteRepository;
	
	public Gerente findById(Long id) {	
		return gerenteRepository.findById(id).orElseThrow();
	}
	
	public List<Gerente> findAll() {
		return gerenteRepository.findAll();
	}	
	
	public Gerente create(Gerente gerente) {	
		return gerenteRepository.save(gerente);	
	}
	
	public Gerente update(Long id, Gerente gerente) {
		Gerente oldGerente = gerenteRepository.findById(id).orElseThrow();
		Endereco oldEndereco = oldGerente.getEndereco();
		Endereco endereco = gerente.getEndereco();
	
		gerente.setEmail(gerente.getEmail() != null ? gerente.getEmail() : oldGerente.getEmail());
		gerente.setEndereco(gerente.getEndereco() != null ? gerente.getEndereco() : oldGerente.getEndereco());
		gerente.setNome(gerente.getNome() != null ? gerente.getNome() : oldGerente.getNome());
		gerente.setTelefone(gerente.getTelefone() != null ? gerente.getTelefone() : oldGerente.getTelefone());
		
		endereco.setLogradouro(endereco.getLogradouro() != null ? endereco.getLogradouro() : oldEndereco.getLogradouro());
		endereco.setNumero(endereco.getNumero() != null ? endereco.getNumero() : oldEndereco.getNumero());
		endereco.setComplemento(endereco.getComplemento() != null ? endereco.getComplemento() : oldEndereco.getComplemento());
		endereco.setBairro(endereco.getBairro() != null ? endereco.getBairro() : oldEndereco.getBairro());
		endereco.setCep(endereco.getCep() != null ? endereco.getCep() : oldEndereco.getCep());
		endereco.setCidade(endereco.getCidade() != null ? endereco.getCidade() : oldEndereco.getCidade());
		endereco.setEstado(endereco.getEstado() != null ? endereco.getEstado() : oldEndereco.getEstado());
		gerente.setEndereco(endereco);
		
		return gerenteRepository.save(gerente);
	}
	
	public void delete(Long id) {
		Gerente gerente = gerenteRepository.findById(id).orElseThrow();
		gerenteRepository.delete(gerente);	
	}
}
