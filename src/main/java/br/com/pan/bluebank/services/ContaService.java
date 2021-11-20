package br.com.pan.bluebank.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dto.ContaDTO;
import br.com.pan.bluebank.mappers.ContaMapper;
import br.com.pan.bluebank.model.Agencia;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.model.ENUM.StatusDeConta;
import br.com.pan.bluebank.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AgenciaService agenciaService;

	public List<Conta> findAll() {
		return contaRepository.findAll();
	}
	
	public List<Conta> findAllAtivas() {
		return contaRepository.findByStatusDeConta(StatusDeConta.ATIVADO);
	}
	
	public Conta findById(Long id) {
		return contaRepository.findById(id).orElseThrow();
	}
	
	public Conta findByIdContaAtiva(Long id) {
		return contaRepository.findByStatusDeContaAndId(StatusDeConta.ATIVADO, id);
	}
	
	public Conta create(ContaDTO dto) {
		
		Cliente cliente = clienteService.findById(dto.getIdCliente());
		Agencia agencia = agenciaService.findById(dto.getIdAgencia());
		
		Conta novaConta = ContaMapper.toEntity(dto, cliente, agencia);
		
		return contaRepository.save(novaConta);
	}
	
	public Conta alterarStatus(Long id, String status) {
		Conta contaAlterada = contaRepository.findById(id).orElseThrow();
		if(StatusDeConta.valueOf(status) == StatusDeConta.ATIVADO) {
			contaAlterada.setStatusDeConta(StatusDeConta.ATIVADO);
		}else {
			contaAlterada.setStatusDeConta(StatusDeConta.DESATIVADO);
			contaAlterada.setSaldo(BigDecimal.ZERO);
		}
		return contaRepository.save(contaAlterada);
	}
	
}
