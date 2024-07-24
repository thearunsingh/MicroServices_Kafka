package com.deliveryboy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public boolean sendContent(String topic,String content)
	{
		TopicBuilder.name(topic).build();
		this.kafkaTemplate.send(topic,content);
		return true;
	}

}
