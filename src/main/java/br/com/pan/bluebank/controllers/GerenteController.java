package br.com.pan.bluebank.controllers;

import java.net.URI;
import java.util.List;

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

import br.com.pan.bluebank.dtos.GerenteDTO;
import br.com.pan.bluebank.dtos.response.MessageResponse;
import br.com.pan.bluebank.dtos.response.MessageResponseImpl;
import br.com.pan.bluebank.models.Gerente;
import br.com.pan.bluebank.services.GerenteService;

@RestController
@RequestMapping(path = "v1/gerentes")
public class GerenteController implements MessageResponse {
	
	@Autowired
	private GerenteService gerenteService;

	@ApiOperation(value = "Retorna um gerente a partir do id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o gerente"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Gerente> findById(@PathVariable Long id){
		return ResponseEntity.ok(this.gerenteService.findById(id));
	}

	@ApiOperation(value = "Retorna uma lista de gerentes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de gerentes"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Gerente>> findAll() {
		return ResponseEntity.ok(this.gerenteService.findAll());
	}
	
	@ApiOperation(value = "Salva um novo gerente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Salva o gerente"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<MessageResponseImpl> create(@RequestBody GerenteDTO gerenteDTO){
		Gerente newGerente = this.gerenteService.create(gerenteDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newGerente.getId()).toUri();
		return ResponseEntity.created(uri).body(createMessageResponse("Gerente criado com sucesso!"));
	}

	@ApiOperation(value = "Atualiza um gerente a partir do id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Atualiza o gerente"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PutMapping(value = "/{id}", produces = "application/json")
		public ResponseEntity<MessageResponseImpl> update(@PathVariable Long id,
		@RequestBody GerenteDTO gerenteDTO) {
		this.gerenteService.update(id, gerenteDTO);
		return ResponseEntity.ok(createMessageResponse("Gerente alterado com sucesso!"));
	}

	@ApiOperation(value = "Apaga um gerente a partir do id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Apaga o gerente"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.gerenteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
