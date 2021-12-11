package br.com.pan.bluebank.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dtos.ContaDTO;
import br.com.pan.bluebank.dtos.ExtratoDTO;
import br.com.pan.bluebank.dtos.filter.ExtratoFilter;
import br.com.pan.bluebank.dtos.response.ContaResponseDTO;
import br.com.pan.bluebank.mappers.ContaMapper;
import br.com.pan.bluebank.model.enums.StatusDeConta;
import br.com.pan.bluebank.models.Agencia;
import br.com.pan.bluebank.models.Cliente;
import br.com.pan.bluebank.models.Conta;
import br.com.pan.bluebank.repositories.ContaRepository;
import br.com.pan.bluebank.services.exceptions.ResourceNotFoundException;
import br.com.pan.bluebank.services.exceptions.StatusContaException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired	
	private ClienteService clienteService;
	
	@Autowired
	private ExtratoService extratoService;

	@Autowired
	private AgenciaService agenciaService;
	
	public List<ContaResponseDTO> findAll() {
		List<Conta> listaConta = contaRepository.findAll();
		return listaConta.stream()				
				.map(conta -> ContaMapper.toDTO(conta))
				.collect(Collectors.toList());
	}

	public List<ContaResponseDTO> findAllAtivas() {
		List<Conta> listaContaAtiva = contaRepository.findByStatusDeConta(StatusDeConta.ATIVADO);
		return listaContaAtiva.stream()
				.map(conta -> ContaMapper.toDTO(conta))
				.collect(Collectors.toList());
	}

	public Conta findById(Long id) {
		return contaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada!"));
	}	
	
	public ContaResponseDTO findByIdResponse(Long id) {
		return ContaMapper.toDTO(findById(id));
	}
	
	protected Conta findByIdContaAtiva(Long id) {
		return contaRepository.findByStatusDeContaAndId(StatusDeConta.ATIVADO, id);
	}

	protected Conta findById(Long id, String texto) {		
		return contaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(texto));
	}	
	
	public Conta create(ContaDTO dto) {
        Cliente cliente = clienteService.findById(dto.getIdCliente());
        Agencia agencia = agenciaService.findById(dto.getIdAgencia());
        Conta novaConta = ContaMapper.toEntity(dto, cliente, agencia);
        novaConta.setNumeroDaConta(setNumeroConta());
        return contaRepository.save(novaConta);
    }

	public ExtratoDTO extratoConta(ExtratoFilter filter){
		Conta conta = findById(filter.getContaId());
		return extratoService.geraExtrato(conta, filter);
	}
	
	public Conta alterarStatus(Long id, String novoStatus) {
		Conta contaAlterada = findById(id);										
		try {	
			verificaStatus(contaAlterada.getStatusDeConta(), novoStatus);			
			contaAlterada.setStatusDeConta(StatusDeConta.valueOf(novoStatus));			
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Status de conta inválido!");
		} 		
		return contaRepository.save(contaAlterada);
	}

	private void verificaStatus(StatusDeConta statusDaConta, String novoStatus) {
		if(statusDaConta.equals(StatusDeConta.valueOf(novoStatus))
				&& StatusDeConta.valueOf(novoStatus).equals(StatusDeConta.DESATIVADO)) {
			throw new StatusContaException("A conta já está desativada!");
		} else if (statusDaConta.equals(StatusDeConta.valueOf(novoStatus))
				&& StatusDeConta.valueOf(novoStatus).equals(StatusDeConta.ATIVADO)){
			throw new StatusContaException("A conta já está ativada!");
		}				
	}

	protected Conta atualizarConta(Conta conta) {
		return contaRepository.save(conta);
	}
		
	private String setNumeroConta() {
        String number = numeroAleatorio();
        Conta nc = contaRepository.findByNumeroDaConta(String.valueOf(number));
        if (nc == null) {
            return String.valueOf(number);
        } else {
            return setNumeroConta();
        }
    } 
	
    private String numeroAleatorio() {
        
        long n =  0 + (long) (Math.random() * ((999999999 - 0) + 1));
        String formatado = String.format("%010d", n);
        
        return formatado.substring(0, 8) + "-" + formatado.charAt(9);
    }
    
}
