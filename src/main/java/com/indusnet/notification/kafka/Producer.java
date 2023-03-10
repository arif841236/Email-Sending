package com.indusnet.notification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class Producer {
	public static final String topic = "totp2";
	  
	  @Autowired 
	  private KafkaTemplate<String, Object> kafkaTemp;
	  
	  public void publishToTopic(Object message) {
		  log.info("Publishing to topic "+topic);
		  this.kafkaTemp.send(topic, message);
	  }
}
