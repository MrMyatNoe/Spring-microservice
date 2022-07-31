package com.tmn.stock.exception;

import org.springframework.http.ResponseEntity;

@SuppressWarnings("serial")
public class BadRequestException extends BaseException{

	public BadRequestException(String message) {
		super(message);
	}

	@Override
	public ResponseEntity<Object> response() {
		return badRequestResponse();
	}

}
