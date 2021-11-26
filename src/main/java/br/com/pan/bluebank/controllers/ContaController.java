package br.com.pan.bluebank.controllers;

import java.net.URI;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pan.bluebank.dto.ContaDTO;
import br.com.pan.bluebank.dto.response.ContaResponseDTO;
import br.com.pan.bluebank.dto.response.MessageResponse;
import br.com.pan.bluebank.dto.response.MessageResponseImpl;
import br.com.pan.bluebank.mappers.ContaMapper;
import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.services.ContaService;

@RestController
@RequestMapping(path = "v1/contas")
public class ContaController implements MessageResponse{
	
	@Autowired
	private ContaService contaService;

	@ApiOperation(value = "Retorna uma lista de contas")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de contas"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<ContaResponseDTO>> findAll(){
		List<ContaResponseDTO> listaContas = contaService.findAll();
		return ResponseEntity.ok(listaContas);
		
	}

	@ApiOperation(value = "Retorna uma lista de contas con status ativo")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de contas"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value = "/ativas", produces = "application/json")
	public ResponseEntity<List<ContaResponseDTO>> findAllAtivas(){
		List<ContaResponseDTO> listaContas = contaService.findAllAtivas();
		return ResponseEntity.ok(listaContas);
		
	}

	@ApiOperation(value = "Retorna uma conta a partir do id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a conta"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<ContaResponseDTO> findByIdResponse(@PathVariable Long id){
		ContaResponseDTO conta = contaService.findByIdResponse(id);
		return ResponseEntity.ok(conta);
	}

	@ApiOperation(value = "Salva uma nova conta")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Salva a conta"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<MessageResponseImpl> create(@RequestBody ContaDTO dto){
		Conta newConta = contaService.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newConta.getId()).toUri();
		return ResponseEntity.created(uri).body(createMessageResponse("Conta criada com sucesso!"));
		}

	@ApiOperation(value = "Altera o status de uma conta a partir do id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Altera o status da conta"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PatchMapping(value = "/{id}",produces = "application/json")
	public ResponseEntity<MessageResponseImpl> alterarStatus(@PathVariable Long id, 
			@RequestParam String status){
		contaService.alterarStatus(id, status);
		return ResponseEntity.ok(createMessageResponse("Status da conta alterado com sucesso!"));
	}
	
}
