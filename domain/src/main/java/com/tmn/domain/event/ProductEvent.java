package com.tmn.domain.event;

import com.tmn.domain.model.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductEvent {

	private String message;
	private String status;
	private Product product;
}
