package com.indusnet.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.notification.dto.EmailSendingRequest;
import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.exception.NotificationSendingException;
import com.indusnet.notification.kafka.Consumer;
import com.indusnet.notification.kafka.KafkaResponse;
import com.indusnet.notification.service.EmailSendingService;

@RestController
@RequestMapping("/api/v0.0.1/notification")
@CrossOrigin
public class EmailSendingController {

	@Autowired
	private EmailSendingService emailSendingService;
	@Autowired
	Consumer consumer;

	@PostMapping("/sendEmailNotification")
	public ResponseEntity<SuccessResponse> sendEmailNotification(@RequestBody EmailSendingRequest sendingRequest)
			throws NotificationSendingException {
		try {
			SuccessResponse successResponse = emailSendingService.sendEmail(sendingRequest);
			return new ResponseEntity<>(successResponse, HttpStatus.OK);
		} catch (Exception e) {
			throw new NotificationSendingException("Email Notification Sending Failed--" + e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<KafkaResponse> kafkaMessage() {
		KafkaResponse kafkaResponse = consumer.getConsumedMessage();
		return new ResponseEntity<>(kafkaResponse, HttpStatus.OK);
	}
}
