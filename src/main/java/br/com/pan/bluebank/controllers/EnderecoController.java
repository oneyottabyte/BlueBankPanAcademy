package br.com.pan.bluebank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.bluebank.model.Endereco;
import br.com.pan.bluebank.services.EnderecoService;

@RestController
@RequestMapping(path = "v1/Endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService service;
    
  
    @GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
