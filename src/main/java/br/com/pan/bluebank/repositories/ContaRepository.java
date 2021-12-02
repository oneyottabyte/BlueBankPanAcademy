package br.com.pan.bluebank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pan.bluebank.model.enums.StatusDeConta;
import br.com.pan.bluebank.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	List<Conta> findByStatusDeConta(StatusDeConta statusDeConta);
	
	Conta findByStatusDeContaAndId(StatusDeConta statusDeConta, Long id);
    
	Conta findByNumeroDaConta(String numero);

}
