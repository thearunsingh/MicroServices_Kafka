package com.deliveryboy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.entity.DetailsInfo;
import com.deliveryboy.service.KafkaService;

@RestController
@RequestMapping("/content")
public class LocationController {
	
	@Autowired
	private KafkaService kafkaService;
	
	@RequestMapping(path = "/send",method = RequestMethod.POST,  consumes = "application/json")
	public ResponseEntity<?> sendContent(@RequestBody DetailsInfo info)
	{
		this.kafkaService.sendContent(info.getTopic(),info.getContent());
		return new ResponseEntity<>(Map.of(info.getTopic(),"sent"),HttpStatus.OK);
		
	}

}
