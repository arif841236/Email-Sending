package com.indusnet.notification.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {
	@Autowired
	Gson gson;

	private KafkaResponse kafkResponse;

	@KafkaListener(topics = "totp2", groupId = "mygroup")
	public void consumeFromTopic(ConsumerRecord<Integer, String> message) {
		this.kafkResponse = gson.fromJson(message.value(), KafkaResponse.class);
	}

	public KafkaResponse getConsumedMessage() {
		log.info("inside kafka " + this.kafkResponse);
		return kafkResponse;
	}
}
