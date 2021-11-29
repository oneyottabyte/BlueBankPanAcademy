package br.com.pan.bluebank.services.exceptions;

public class SaldoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SaldoInvalidoException(String msg) {
		super(msg);
	}
}
