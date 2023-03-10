package com.indusnet.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.notification.dto.SMSSendingRequest;
import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.exception.NotificationSendingException;
import com.indusnet.notification.service.SMSSendingService;

@RestController
@RequestMapping("/api/v0.0.1/notification")
@CrossOrigin
public class SMSSendingController {

	@Autowired
	private SMSSendingService smsSendingService;

	@PostMapping("/sendSMSNotification")
	public ResponseEntity<SuccessResponse> sendSMSNotification(@RequestBody SMSSendingRequest sendingRequest)
			throws NotificationSendingException {
		try {
			SuccessResponse successResponse = smsSendingService.sendSMS(sendingRequest);
			return new ResponseEntity<>(successResponse, HttpStatus.OK);
		} catch (Exception e) {
			throw new NotificationSendingException("SMS Notification Sending Failed--" + e.getMessage());
		}
	}

}
