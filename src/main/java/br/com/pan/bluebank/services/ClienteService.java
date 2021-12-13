package br.com.pan.bluebank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dtos.ClienteDTO;
import br.com.pan.bluebank.mappers.ClienteMapper;
import br.com.pan.bluebank.models.Cliente;
import br.com.pan.bluebank.models.Endereco;
import br.com.pan.bluebank.repositories.ClienteRepository;
import br.com.pan.bluebank.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired 
	private EmailNotificationService notification;
	
	public Cliente findById(Long id) {	
		return clienteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}	

	public Cliente create(ClienteDTO dto) {	
		Endereco endereco = enderecoService.create(dto.getEndereco());
		dto.setEndereco(endereco);
		Cliente entity = ClienteMapper.toEntity(dto);
		notification.addSubscription(dto.getEmail());
		return clienteRepository.save(entity);	
	}
	
	public Cliente update(Long id, ClienteDTO dto) {
		Cliente cliente = findById(id);		
		Endereco endereco = enderecoService.create(dto.getEndereco());
		dto.setEndereco(endereco);
		Cliente updatedEntity = ClienteMapper.updateEntity(cliente, dto);
		
		return clienteRepository.save(updatedEntity);
	}	
	
	public void delete(Long id) {
		Cliente cliente = findById(id);
		clienteRepository.delete(cliente);	
	}
}
