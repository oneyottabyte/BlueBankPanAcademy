package br.com.pan.bluebank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dto.ClienteDTO;
import br.com.pan.bluebank.mappers.ClienteMapper;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Endereco;
import br.com.pan.bluebank.repositories.ClienteRepository;
import br.com.pan.bluebank.repositories.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	public static EnderecoRepository enderecoRepository;
			
	public Cliente create(ClienteDTO dto) {	
		Endereco endereco = enderecoRepository.save(dto.getEndereco());
		dto.setEndereco(endereco);
		Cliente entity = ClienteMapper.toEntity(dto);
		return clienteRepository.save(entity);	
	}
	
	public Cliente update(Long id, ClienteDTO dto) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow();
		Cliente updatedEntity = ClienteMapper.updateEntity(cliente, dto);
		
		return clienteRepository.save(updatedEntity);
	}
	
	public Cliente findById(Long id) {	
		return clienteRepository.findById(id).orElseThrow();
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}	
	
	public void delete(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow();
		clienteRepository.delete(cliente);	
	}
}
