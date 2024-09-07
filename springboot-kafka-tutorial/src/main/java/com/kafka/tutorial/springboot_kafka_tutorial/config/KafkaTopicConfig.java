package com.kafka.tutorial.springboot_kafka_tutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic tutorialTopic() {
		return TopicBuilder.name("tutTopic").build();
	}
	
	@Bean
	public NewTopic tutorialJsonTopic() {
		return TopicBuilder.name("tutTopicJson").build();
	}
}
