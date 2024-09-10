package com.kafka.tutorial.springboot_kafka_tutorial.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.tutorial.springboot_kafka_tutorial.payload.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@KafkaListener(topics = "tutTopicJson", groupId = "myGroup")
	private void consume(User user) {
		LOGGER.info("JSON message consumed successfully, {}", user.toString());
	}
}
