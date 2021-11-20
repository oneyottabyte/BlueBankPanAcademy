package br.com.pan.bluebank.controllers;

import java.net.URI;

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
	
	@PostMapping
	public ResponseEntity<Movimentacao> create(		
			@RequestBody MovimentacaoDTO dto){
		
		Movimentacao newMovimentacao = this.service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newMovimentacao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(path = "/{origemId}")
	public ResponseEntity<Movimentacao> findById(@PathVariable Long origemId){
		return ResponseEntity.ok(this.service.findById(origemId));
	}	

	@GetMapping
	public ResponseEntity<Page<Movimentacao>> findAll(Pageable page) {
			return ResponseEntity.ok(this.service.findAll(page));
	}
		
}
