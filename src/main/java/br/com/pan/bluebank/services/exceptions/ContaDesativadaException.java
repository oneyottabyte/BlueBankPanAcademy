package br.com.pan.bluebank.services.exceptions;

public class ContaDesativadaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContaDesativadaException(String msg) {
		super(msg);
	}
}
