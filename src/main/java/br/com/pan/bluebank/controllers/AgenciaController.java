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

import br.com.pan.bluebank.dto.AgenciaDTO;
import br.com.pan.bluebank.model.Agencia;
import br.com.pan.bluebank.services.AgenciaService;

@RestController
@RequestMapping(path = "v1/agencias")
public class AgenciaController {
	
	@Autowired
	private AgenciaService agenciaService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Agencia> findById(@PathVariable Long id){
		Agencia obj = this.agenciaService.findById(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	public ResponseEntity<List<Agencia>> findAll() {
		List<Agencia> list = agenciaService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping(value = "/{id}")
		public ResponseEntity<Agencia> update(@PathVariable Long id,
		@RequestBody AgenciaDTO dto) {
		Agencia updatedAgencia = agenciaService.update(id, dto);
		return ResponseEntity.ok(updatedAgencia);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		agenciaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Agencia> create(@RequestBody AgenciaDTO dto){
		Agencia newAgencia = agenciaService.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newAgencia.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
