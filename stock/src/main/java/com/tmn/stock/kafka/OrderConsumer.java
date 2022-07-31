package com.tmn.stock.kafka;

import java.time.Clock;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tmn.domain.model.OrderEvent;
import com.tmn.stock.model.PlaceOrder;
import com.tmn.stock.repo.PlaceOrderRepo;

@Service
public class OrderConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

	@Autowired
	PlaceOrderRepo repo;

	@Autowired
	Clock clock;

	@KafkaListener(topics = "${spring.kafka.topic1.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {

		LOGGER.info(String.format("Order received in stock module => %S", event.toString()));

		PlaceOrder order = new PlaceOrder();
		order.setMessage(event.getMessage());
		order.setStatus(event.getStatus());
		order.setOrder(event.getOrder());
		order.setCreatedDate(LocalDateTime.now(clock));
		repo.save(order);

	}
}
