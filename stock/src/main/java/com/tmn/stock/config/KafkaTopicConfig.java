
package com.tmn.stock.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Value("${spring.kafka.topic1.name}")
	private String topicNameOne;
	
	@Value("${spring.kafka.topic2.name}")
	private String topicNameTwo;

    @Bean
    NewTopic topicOne() {
        return TopicBuilder.name(topicNameOne).build();
    }
    
    @Bean
    NewTopic topicTwo() {
        return TopicBuilder.name(topicNameTwo).build();
    }
}
