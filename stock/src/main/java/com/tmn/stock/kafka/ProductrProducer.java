package com.tmn.stock.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.tmn.domain.event.ProductEvent;

@Service
public class ProductrProducer {
	
	@Autowired
	KafkaTemplate<String, ProductEvent> kafkaTemplate;
	
	@Autowired
	private NewTopic topicTwo;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductrProducer.class);
	
	public void sendMessage(ProductEvent event) {
		LOGGER.info(String.format("Product Save Event", event.toString()));
		
		Message<ProductEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topicTwo.name())
				.build();
		
		kafkaTemplate.send(message);
	}
}
