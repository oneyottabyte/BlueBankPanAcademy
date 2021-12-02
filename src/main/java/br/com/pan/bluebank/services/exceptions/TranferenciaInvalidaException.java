package br.com.pan.bluebank.services.exceptions;

public class TranferenciaInvalidaException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TranferenciaInvalidaException(String msg) {
		super(msg);
	}
}