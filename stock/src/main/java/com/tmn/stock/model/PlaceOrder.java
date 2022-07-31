package com.tmn.stock.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tmn.domain.model.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Document(collection = "place_orders")
public class PlaceOrder {

	@Id
	private String id;
	private String message;
	private String status;
	private Order order;
	private LocalDateTime createdDate;
}
