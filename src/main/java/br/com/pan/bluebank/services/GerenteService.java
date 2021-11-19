package br.com.pan.bluebank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dto.ClienteDTO;
import br.com.pan.bluebank.dto.GerenteDTO;
import br.com.pan.bluebank.mappers.ClienteMapper;
import br.com.pan.bluebank.mappers.GerenteMapper;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Endereco;
import br.com.pan.bluebank.model.Gerente;
import br.com.pan.bluebank.repositories.EnderecoRepository;
import br.com.pan.bluebank.repositories.GerenteRepository;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository gerenteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Gerente findById(Long id) {	
		return gerenteRepository.findById(id).orElseThrow();
	}
	
	public List<Gerente> findAll() {
		return gerenteRepository.findAll();
	}	
	
	public Gerente create(GerenteDTO gerenteDTO) {	
		Endereco endereco = enderecoRepository.save(gerenteDTO.getEndereco());
		gerenteDTO.setEndereco(endereco);
		Gerente entity = GerenteMapper.toEntity(gerenteDTO);
		return gerenteRepository.save(entity);	
	}
	
	public Gerente update(Long id, GerenteDTO gerenteDTO) {
		Gerente gerente = gerenteRepository.findById(id).orElseThrow();
		Gerente updatedEntity = GerenteMapper.updateEntity(gerente, gerenteDTO);
		enderecoRepository.save(updatedEntity.getEndereco());
		return gerenteRepository.save(updatedEntity);
	}
	
	public void delete(Long id) {
		Gerente gerente = gerenteRepository.findById(id).orElseThrow();
		gerenteRepository.delete(gerente);	
	}
}
