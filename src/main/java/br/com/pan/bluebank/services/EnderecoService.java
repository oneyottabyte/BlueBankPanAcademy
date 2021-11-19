package br.com.pan.bluebank.services;

import br.com.pan.bluebank.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.bluebank.repositories.EnderecoRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    public EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
        ClienteService.enderecoRepository = this.enderecoRepository;
    }

    @Transactional(readOnly = true)
    public List<Endereco> findAll() {
        List<Endereco> entities = enderecoRepository.findAll();
        return entities;
    }
    
     @Transactional(readOnly = true)
    public Endereco findById(Long id) {
	Endereco entity = verifyIfExists(id);
	return entity;
    }
    
    @Transactional(readOnly = true)
    private Endereco verifyIfExists(Long id) throws RuntimeException {		
	return enderecoRepository.findById(id).orElseThrow(() -> 
                new EntityNotFoundException("Adress not found."));
    }
}
