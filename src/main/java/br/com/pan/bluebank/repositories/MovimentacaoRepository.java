package br.com.pan.bluebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    
}
