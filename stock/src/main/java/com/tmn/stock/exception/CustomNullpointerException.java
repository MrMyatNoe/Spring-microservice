package com.tmn.stock.exception;

import org.springframework.http.ResponseEntity;

@SuppressWarnings("serial")
public class CustomNullpointerException extends BaseException{

	public CustomNullpointerException(String message) {
		super(message);
	}

	@Override
	public ResponseEntity<Object> response() {
		return nullResponse();
	}

	
}
