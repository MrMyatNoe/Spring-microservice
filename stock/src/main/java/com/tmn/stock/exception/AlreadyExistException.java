package com.tmn.stock.exception;

import org.springframework.http.ResponseEntity;

@SuppressWarnings("serial")
public class AlreadyExistException extends BaseException{

	public AlreadyExistException(String message) {
		super(message);
	}

	@Override
	public ResponseEntity<Object> response() {
		return badRequestResponse();
	}

}
