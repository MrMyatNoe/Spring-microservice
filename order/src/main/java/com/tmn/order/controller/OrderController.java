package com.tmn.order.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmn.domain.model.Order;
import com.tmn.domain.model.OrderEvent;
import com.tmn.order.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	OrderProducer orderProducer;

//	@RequestMapping(path = "/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {
		System.out.println("order " + order);
		order.setOrderId(UUID.randomUUID().toString());

		OrderEvent event = new OrderEvent();
		event.setMessage("PENDING");
		event.setStatus("Order status is in pending state");
		event.setOrder(order);

		orderProducer.sendMessage(event);
		return "Order placed successfully ....";
	}

}
