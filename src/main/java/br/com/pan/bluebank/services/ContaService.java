package br.com.pan.bluebank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dto.ContaDTO;
import br.com.pan.bluebank.mappers.ContaMapper;
import br.com.pan.bluebank.model.Agencia;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.repositories.AgenciaRepository;
import br.com.pan.bluebank.repositories.ClienteRepository;
import br.com.pan.bluebank.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AgenciaRepository agenciaRepository;

	public List<Conta> findAll() {
		return contaRepository.findAll();
	}
	
	public Conta findById(Long id) {
		return contaRepository.findById(id).orElseThrow();
	}
	
	public Conta create(ContaDTO dto) {
		
		Cliente cliente = clienteRepository.findById(dto.getIdCliente()).orElseThrow();
		Agencia agencia = agenciaRepository.findById(dto.getIdAgencia()).orElseThrow();
		
		Conta novaConta = ContaMapper.toEntity(dto, cliente, agencia);
		
		return contaRepository.save(novaConta);
	}
	
}
