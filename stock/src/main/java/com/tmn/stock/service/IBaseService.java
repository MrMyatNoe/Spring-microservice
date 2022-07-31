package com.tmn.stock.service;

import java.util.List;

public interface IBaseService<T> {
	
	T save(T t);
	
	List<T> getAll();
	
	T update(T t);
	
	void deleteById(String id);
	
	T findById(String id);
}
