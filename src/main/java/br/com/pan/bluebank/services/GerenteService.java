package br.com.pan.bluebank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dtos.GerenteDTO;
import br.com.pan.bluebank.mappers.GerenteMapper;
import br.com.pan.bluebank.models.Endereco;
import br.com.pan.bluebank.models.Gerente;
import br.com.pan.bluebank.repositories.GerenteRepository;
import br.com.pan.bluebank.services.exceptions.ResourceNotFoundException;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository gerenteRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public Gerente findById(Long id) {	
		return gerenteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Gerente não encontrado!"));
	}
	
	public List<Gerente> findAll() {
		return gerenteRepository.findAll();
	}	
	
	public Gerente create(GerenteDTO gerenteDTO) {	
		Endereco endereco = enderecoService.create(gerenteDTO.getEndereco());
		gerenteDTO.setEndereco(endereco);
		Gerente entity = GerenteMapper.toEntity(gerenteDTO);
		return gerenteRepository.save(entity);	
	}
	
	public Gerente update(Long id, GerenteDTO gerenteDTO) {
		Gerente gerente = findById(id);
		Gerente updatedEntity = GerenteMapper.updateEntity(gerente, gerenteDTO);
		enderecoService.create(updatedEntity.getEndereco());
		return gerenteRepository.save(updatedEntity);
	}
	
	public void delete(Long id) {
		Gerente gerente = findById(id);
		gerenteRepository.delete(gerente);	
	}
}
