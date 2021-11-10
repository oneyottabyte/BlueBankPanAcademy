package br.com.pan.bluebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
    
}
