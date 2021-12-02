package br.com.pan.bluebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
