package com.tmn.stock.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tmn.stock.model.PlaceOrder;

@Repository
public interface PlaceOrderRepo extends MongoRepository<PlaceOrder, String>{

}
