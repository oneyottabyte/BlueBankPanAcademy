package br.com.pan.bluebank.controllers;

import java.net.URI;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pan.bluebank.dto.MovimentacaoDTO;
import br.com.pan.bluebank.model.Movimentacao;
import br.com.pan.bluebank.services.MovimentacaoService;

@RestController
@RequestMapping(path = "v1/movimentacao")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoService service;

	@ApiOperation(value = "Salva uma nova movimentaçao")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Salva a movimentação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Movimentacao> create(		
			@RequestBody MovimentacaoDTO dto){
		
		Movimentacao newMovimentacao = this.service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newMovimentacao.getId()).toUri();
		return ResponseEntity.created(uri).body(newMovimentacao);
	}

	@ApiOperation(value = "Retorna uma movimentaçao a partir do id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a movimentação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(path = "/{origemId}", produces = "application/json")
	public ResponseEntity<Movimentacao> findById(@PathVariable Long origemId){
		return ResponseEntity.ok(this.service.findById(origemId));
	}

	@ApiOperation(value = "Retorna uma lista de movimentações")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de movimentações"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping
	public ResponseEntity<Page<Movimentacao>> findAll(Pageable page) {
			return ResponseEntity.ok(this.service.findAll(page));
	}
		
}
