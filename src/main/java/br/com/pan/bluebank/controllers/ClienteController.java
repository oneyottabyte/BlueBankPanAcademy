package br.com.pan.bluebank.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.pan.bluebank.dto.ClienteDTO;
import br.com.pan.bluebank.model.Cliente;
import br.com.pan.bluebank.services.ClienteService;

@RestController
@RequestMapping(path = "v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente obj = this.service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping(value = "/{id}")
		public ResponseEntity<Cliente> update(@PathVariable Long id,
		@RequestBody ClienteDTO dto) {
		Cliente updatedCliente = service.update(id, dto);
		return ResponseEntity.ok(updatedCliente);
	}
	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Long id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody ClienteDTO dto){
		Cliente newCliente = service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCliente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
