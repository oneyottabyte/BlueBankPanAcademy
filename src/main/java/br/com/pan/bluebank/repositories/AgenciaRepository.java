package br.com.pan.bluebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.model.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long>{
    
}
