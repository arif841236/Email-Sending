package com.indusnet.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.dto.WhatsappSendingRequest;
import com.indusnet.notification.exception.NotificationSendingException;
import com.indusnet.notification.service.WhatsappSendingService;

@RestController
@RequestMapping("/api/v0.0.1/notification")
@CrossOrigin
public class WhatsappSendingController {
	
	@Autowired
	private WhatsappSendingService whatsappSendingService;
	
	@PostMapping("/sendWhatsappNotification")
	public ResponseEntity<SuccessResponse> sendWhatsappNotification(@RequestBody WhatsappSendingRequest sendingRequest)
			throws NotificationSendingException {
		try {
			SuccessResponse successResponse = whatsappSendingService.sendWhatsapp(sendingRequest);
			return new ResponseEntity<>(successResponse, HttpStatus.OK);
		} catch (Exception e) {
			throw new NotificationSendingException("Whatsapp Notification Sending Failed--"+e.getMessage());
		}
	}

}
