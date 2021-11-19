package br.com.pan.bluebank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.repositories.EnderecoRepository;

@Service
public class EnderecoService {
		
	public EnderecoRepository enderecoRepository;
	
	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
		ClienteService.enderecoRepository = this.enderecoRepository;
	}
}
