package com.tmn.stock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

	protected ResponseEntity<Object> okResponse(Object o){
		return new ResponseEntity<Object>(o, HttpStatus.OK);
	}
	
	protected ResponseEntity<Object> createResponse(Object o){
		return new ResponseEntity<Object>(o, HttpStatus.CREATED);
	}
	
	
	protected ResponseEntity<Object> deleteResponse(Object o){
		return new ResponseEntity<Object>(o, HttpStatus.OK);
	}
}
