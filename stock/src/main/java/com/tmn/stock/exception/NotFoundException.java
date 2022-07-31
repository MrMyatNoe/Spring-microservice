package com.tmn.stock.exception;

import org.springframework.http.ResponseEntity;

public class NotFoundException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1079309984026751927L;

	public NotFoundException(String message) {
		super(message);
	}

	@Override
	public ResponseEntity<Object> response() {
		return notFoundResponse();
	}

}
