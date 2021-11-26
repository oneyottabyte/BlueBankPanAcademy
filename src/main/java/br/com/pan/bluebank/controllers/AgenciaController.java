package br.com.pan.bluebank.controllers;

import java.net.URI;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pan.bluebank.dto.AgenciaDTO;
import br.com.pan.bluebank.dto.response.AgenciaResponseDTO;
import br.com.pan.bluebank.dto.response.MessageResponse;
import br.com.pan.bluebank.dto.response.MessageResponseImpl;
import br.com.pan.bluebank.model.Agencia;
import br.com.pan.bluebank.services.AgenciaService;


@RestController
@RequestMapping(path = "v1/agencias")
public class AgenciaController implements MessageResponse {
	
	@Autowired
	private AgenciaService agenciaService;

	@ApiOperation(value = "Retorna uma Agência a partir do id informado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a agência"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(path = "/{id}", produces="application/json")
	public ResponseEntity<AgenciaResponseDTO> findById(@PathVariable Long id){
		AgenciaResponseDTO obj = this.agenciaService.findByIdResponse(id);
		return ResponseEntity.ok(obj);
	}

	@ApiOperation(value = "Retorna uma lista de agências")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de agências"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(produces="application/json")
	public ResponseEntity<List<AgenciaResponseDTO>> findAll() {
		List<AgenciaResponseDTO> list = agenciaService.findAll();
		return ResponseEntity.ok(list);
	}

	@ApiOperation(value = "Atualiza uma agência")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Atualiza a agência"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PutMapping(value = "/{id}", produces="application/json", consumes="application/json")
		public ResponseEntity<MessageResponseImpl> update(@PathVariable Long id,
		@RequestBody AgenciaDTO dto) {
		Agencia updatedAgencia = agenciaService.update(id, dto);
		return ResponseEntity.ok(createMessageResponse("Agência atualizada com sucesso!"));
	}

	@ApiOperation(value = "Apaga uma agência")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Apaga a agência"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@DeleteMapping(value = "/{id}", consumes="application/json")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		agenciaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Salva uma agência")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Salva a agência"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<MessageResponseImpl> create(@RequestBody AgenciaDTO dto){
		Agencia newAgencia = agenciaService.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newAgencia.getId()).toUri();
		return ResponseEntity.created(uri).body(createMessageResponse("Agência criada com sucesso!"));
	}

}
