package br.com.pan.bluebank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.model.Movimentacao;
import br.com.pan.bluebank.model.enums.TipoMovimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>, JpaSpecificationExecutor<Movimentacao> {

	List<Movimentacao> findAllByIdAndTipo(Long origemId, TipoMovimentacao valueOf);
    
	List<Movimentacao> findAllByContaOrigemOrContaDestino(Conta contaOrigem, Conta contaDestino);
}
