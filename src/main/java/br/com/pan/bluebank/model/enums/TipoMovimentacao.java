package br.com.pan.bluebank.model.enums;

import java.math.BigDecimal;

import br.com.pan.bluebank.model.Conta;
import br.com.pan.bluebank.model.Movimentacao;
import br.com.pan.bluebank.services.exceptions.SaldoInvalidoException;

public enum TipoMovimentacao {
	
	DEPOSITO {
		@Override
		public boolean possuiContaDestino() {			
			return false;
		}

		@Override
		public Movimentacao atualizaSaldo(Movimentacao mov) {	
			Conta conta = mov.getContaOrigem();
			BigDecimal novoSaldo = conta.getSaldo().add(mov.getValorTransacao());
			mov.getContaOrigem().setSaldo(novoSaldo);				
			return mov;
		}
	}, SAQUE {
		@Override
		public boolean possuiContaDestino() {			
			return false;
		}

		@Override
		public Movimentacao atualizaSaldo(Movimentacao mov) {
			Conta conta = mov.getContaOrigem();
			validaSaldo(conta.getSaldo(), mov.getValorTransacao());
			BigDecimal novoSaldo = conta.getSaldo().subtract(mov.getValorTransacao());
			mov.getContaOrigem().setSaldo(novoSaldo);			
			return mov;
		}
	}, TRANSFERENCIA {
		@Override
		public boolean possuiContaDestino() {			
			return true;
		}

		@Override
		public Movimentacao atualizaSaldo(Movimentacao mov) {
			Conta contaOrigem = mov.getContaOrigem();
			Conta contaDestino = mov.getContaDestino();
		
			BigDecimal valorTransacao = mov.getValorTransacao();	

			validaSaldo(contaOrigem.getSaldo(), valorTransacao);
			
			mov.getContaOrigem().setSaldo(contaOrigem.getSaldo().subtract(valorTransacao));
			mov.getContaDestino().setSaldo(contaDestino.getSaldo().add(valorTransacao));		
			return mov;			
		}		
	};
		
	public abstract boolean possuiContaDestino();

	public abstract Movimentacao atualizaSaldo(Movimentacao mov);
	
	public void validaSaldo(BigDecimal saldo, BigDecimal valorTransacao) {
		if(saldo.compareTo(valorTransacao) < 0)
			throw new SaldoInvalidoException("Saldo insuficiente!");
	}
	
}