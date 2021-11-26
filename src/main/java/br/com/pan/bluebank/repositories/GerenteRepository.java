package br.com.pan.bluebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.model.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
    
}
