package br.com.pan.bluebank.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.dtos.ContaDTO;
import br.com.pan.bluebank.dtos.ExtratoDTO;
import br.com.pan.bluebank.dtos.filter.ExtratoFilter;
import br.com.pan.bluebank.dtos.response.ContaResponseDTO;
import br.com.pan.bluebank.mappers.ContaMapper;
import br.com.pan.bluebank.model.Agencia;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.model.enums.StatusDeConta;
import br.com.pan.bluebank.repositories.ContaRepository;
import br.com.pan.bluebank.services.exceptions.ResourceNotFoundException;

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
		List<Conta> listaContaAtiva = contaRepository.
				findByStatusDeConta(StatusDeConta.ATIVADO);
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
	
	public Conta create(ContaDTO dto) {
        Cliente cliente = clienteService.findById(dto.getIdCliente());
        Agencia agencia = agenciaService.findById(dto.getIdAgencia());
        Conta novaConta = ContaMapper.toEntity(dto, cliente, agencia);
        novaConta.setNumeroDaConta(setNumeroConta());
        return contaRepository.save(novaConta);
    }

	public Conta alterarStatus(Long id, String status) {
		Conta contaAlterada = findById(id);
		try {
			if (StatusDeConta.valueOf(status) == StatusDeConta.ATIVADO) {
				contaAlterada.setStatusDeConta(StatusDeConta.ATIVADO);
			} else if (StatusDeConta.valueOf(status) == StatusDeConta.DESATIVADO) {
				contaAlterada.setStatusDeConta(StatusDeConta.DESATIVADO);
				contaAlterada.setSaldo(BigDecimal.ZERO);
			}
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Status de conta inválido!");
		}
		return contaRepository.save(contaAlterada);
	}

	protected Conta atualizarConta(Conta conta) {
		return contaRepository.save(conta);
	}
	
	protected Conta findByIdContaAtiva(Long id) {
		return contaRepository.findByStatusDeContaAndId(StatusDeConta.ATIVADO, id);
	}

	protected Conta findById(Long id, String texto) {		
		return contaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(texto));
	}
	
	public ExtratoDTO extratoConta(ExtratoFilter filter){
		Conta conta = findById(filter.getContaId());
		return extratoService.geraExtrato(conta, filter);
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
	
    public String numeroAleatorio() {
        
        long n =  0 + (long) (Math.random() * ((999999999 - 0) + 1));
        String formatado = String.format("%010d", n);
        
        return formatado.substring(0, 8) + "-" + formatado.charAt(9);
    }
    
}
