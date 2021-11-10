package br.com.pan.bluebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
}
