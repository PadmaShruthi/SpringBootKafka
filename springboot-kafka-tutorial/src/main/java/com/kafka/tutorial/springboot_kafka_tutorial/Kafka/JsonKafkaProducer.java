package com.kafka.tutorial.springboot_kafka_tutorial.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.tutorial.springboot_kafka_tutorial.payload.User;

@Service
public class JsonKafkaProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data) {
		Message<User> message= MessageBuilder.withPayload(data).setHeaderIfAbsent(KafkaHeaders.TOPIC, "tutTopicJson").build();
		kafkaTemplate.send(message);
		
		LOGGER.info("Message sent successfully {}", data.toString());
	}
	
}
