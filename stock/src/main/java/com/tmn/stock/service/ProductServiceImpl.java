package com.tmn.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmn.domain.model.Product;
import com.tmn.stock.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired(required = true)
	ProductRepository productRepo;

	@Override
	public Product save(Product t) {
		return productRepo.save(t);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
