package com.tmn.stock.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmn.domain.event.ProductEvent;
import com.tmn.domain.model.Product;
import com.tmn.stock.exception.BadRequestException;
import com.tmn.stock.exception.BaseException;
import com.tmn.stock.exception.CustomNullpointerException;
import com.tmn.stock.kafka.ProductrProducer;
import com.tmn.stock.service.ProductService;

@RequestMapping(path = "/api/stock/products")
@RestController
public class ProductController extends BaseController {

	@Autowired
	ProductrProducer productProducer;

	@Autowired
	ProductService productService;

	@RequestMapping()
	public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
		try {
			checkNull(product);
			productService.save(product);
			
			ProductEvent event = new ProductEvent();
			event.setProduct(product);
			event.setMessage("Product saved successfully");
			event.setStatus("444");
			productProducer.sendMessage(event);
			
			return new ResponseEntity<Object>(event, HttpStatus.ACCEPTED);
		} catch (BaseException e) {
			return e.response();
		}
	}

	private void checkNull(Product p) throws BaseException {
		Optional.ofNullable(p.getName())
				.orElseThrow(() -> new CustomNullpointerException("Product should not be null"));
		Optional.ofNullable(p.getPrice())
				.orElseThrow(() -> new CustomNullpointerException("Price should not be null"));
		Optional.ofNullable(p.getPrice() < 0)
		.orElseThrow(() -> new BadRequestException("Price should not be less than 0"));
		Optional.ofNullable(p.getQuantity())
				.orElseThrow(() -> new CustomNullpointerException("Quantity should not be null"));
		Optional.ofNullable(p.getQuantity())
				.orElseThrow(() -> new BadRequestException("Quantity should not be less than 0"));
	}
}
