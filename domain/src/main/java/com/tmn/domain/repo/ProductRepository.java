package com.tmn.domain.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tmn.domain.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
