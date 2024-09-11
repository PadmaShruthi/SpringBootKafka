package com.example.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.springboot.kafka.entity.WikimediaData;
import com.example.springboot.kafka.repository.WikimediaRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediaRepository repository;
	
	public KafkaDatabaseConsumer(WikimediaRepository repository) {
		super();
		this.repository = repository;
	}



	@KafkaListener(topics = "wikimedia_recents", groupId = "myGroup")
	public void consume(String eventMessage) {
		LOGGER.info("Event message received {}", eventMessage);
		
		WikimediaData data = new WikimediaData();
		data.setWikiEventData(eventMessage);
		repository.save(data);
	}
}
