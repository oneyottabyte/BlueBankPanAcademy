package br.com.pan.bluebank.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    
}
