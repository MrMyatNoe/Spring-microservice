package com.tmn.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "products")
public class Product {

	@Id
	private String id;
	private String name;
	private double price;
	private int quantity;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}
