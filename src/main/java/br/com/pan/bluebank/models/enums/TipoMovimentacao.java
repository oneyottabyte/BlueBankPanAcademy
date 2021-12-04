package br.com.pan.bluebank.models.enums;

import java.math.BigDecimal;

import br.com.pan.bluebank.models.Conta;
import br.com.pan.bluebank.models.Movimentacao;
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
			
			validaValorTransacao(conta.getSaldo(), mov.getValorTransacao());
			
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

			validaValorTransacao(contaOrigem.getSaldo(), valorTransacao);
			
			mov.getContaOrigem().setSaldo(contaOrigem.getSaldo().subtract(valorTransacao));
			mov.getContaDestino().setSaldo(contaDestino.getSaldo().add(valorTransacao));		
			return mov;			
		}		
	};
		
	public abstract boolean possuiContaDestino();

	public abstract Movimentacao atualizaSaldo(Movimentacao mov);
	
	public void validaValorTransacao(BigDecimal saldo, BigDecimal valorTransacao) {
		if(saldo.compareTo(valorTransacao) < 0)
			throw new SaldoInvalidoException("Saldo insuficiente!");
	}
	
}