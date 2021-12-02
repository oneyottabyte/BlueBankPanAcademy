package br.com.pan.bluebank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.bluebank.models.Endereco;
import br.com.pan.bluebank.services.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "v1/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoService service;

	@ApiOperation(value = "Retorna uma lista de endereços")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de endereços"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @GetMapping(produces = "application/json")
	public ResponseEntity<List<Endereco>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}
}
