package br.com.pan.bluebank.controllers;

import java.net.URI;
import java.util.List;

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

import br.com.pan.bluebank.dto.GerenteDTO;
import br.com.pan.bluebank.model.Gerente;
import br.com.pan.bluebank.services.GerenteService;

@RestController
@RequestMapping(path = "v1/gerentes")
public class GerenteController {
	
	@Autowired
	private GerenteService gerenteService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Gerente> findById(@PathVariable Long id){
		Gerente obj = this.gerenteService.findById(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	public ResponseEntity<List<Gerente>> findAll() {
		List<Gerente> list = gerenteService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping(value = "/{id}")
		public ResponseEntity<Gerente> update(@PathVariable Long id,
		@RequestBody GerenteDTO gerenteDTO) {
		Gerente updatedGerente = gerenteService.update(id, gerenteDTO);
		return ResponseEntity.ok(updatedGerente);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		gerenteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Gerente> create(@RequestBody GerenteDTO gerenteDTO){
		Gerente newGerente = gerenteService.create(gerenteDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newGerente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
