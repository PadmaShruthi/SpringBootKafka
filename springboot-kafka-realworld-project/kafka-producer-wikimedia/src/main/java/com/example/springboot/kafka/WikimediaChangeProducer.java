package com.example.springboot.kafka;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangeProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangeProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaChangeProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException {
		String topic = "wikimedia_recents";
		
		EventHandler eventHandler = new WikimediaEventHandler(kafkaTemplate, topic);
		String url ="https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		TimeUnit.SECONDS.sleep(10);
	}
	
}
