package com.tmn.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tmn.stock.response.DefaultResponse;

@SuppressWarnings("serial")
public abstract class BaseException extends RuntimeException {

	public BaseException(String message) {
		super(message);
	}

	protected ResponseEntity<Object> badRequestResponse() {
		DefaultResponse res = new DefaultResponse();
		res.setMessage(getMessage());
		return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> nullResponse() {
		DefaultResponse res = new DefaultResponse();
		res.setMessage(getMessage());
		return new ResponseEntity<Object>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	protected ResponseEntity<Object> notFoundResponse() {
		DefaultResponse res = new DefaultResponse();
		res.setMessage(getMessage());
		return new ResponseEntity<Object>(res,HttpStatus.NOT_FOUND);
	}

	public abstract ResponseEntity<Object> response();

}
