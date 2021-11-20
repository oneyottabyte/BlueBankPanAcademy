package br.com.pan.bluebank.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pan.bluebank.model.Endereco;
import br.com.pan.bluebank.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	public EnderecoRepository enderecoRepository;

	@Transactional(readOnly = true)
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Endereco findById(Long id) {
		return enderecoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
	}

}
