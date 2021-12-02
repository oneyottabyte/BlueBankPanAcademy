package br.com.pan.bluebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
