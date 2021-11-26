package br.com.pan.bluebank.dto.response;

public class MessageResponseImpl {

	private String message;
	
	public MessageResponseImpl() {
		super();
	}

	public MessageResponseImpl(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}		
}
