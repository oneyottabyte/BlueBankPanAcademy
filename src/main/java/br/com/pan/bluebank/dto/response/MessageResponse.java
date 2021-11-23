package br.com.pan.bluebank.dto.response;

public interface MessageResponse {
	
	public default MessageResponseImpl createMessageResponse(String text) {
		return new MessageResponseImpl(text);
	}
}
