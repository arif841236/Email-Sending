package com.indusnet.notification.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.notification.dto.NotificationTemplateRequest;
import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.dto.TemplateListResponse;
import com.indusnet.notification.exception.TemplateNotFound;
import com.indusnet.notification.service.NotificationTemplateService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v0.0.1/notification")
@CrossOrigin
@Slf4j
public class NotificationTemplateController {

	@Autowired
	private NotificationTemplateService templateService;

	@PostMapping("/saveNotificationTemplate")
	@Transactional
	public ResponseEntity<SuccessResponse> saveNotificationTemplate(
			@RequestBody NotificationTemplateRequest templateRequest) throws TemplateNotFound {
		if (templateRequest == null) {
			throw new TemplateNotFound("Request body should not be blank");
		}
		SuccessResponse successResponse = templateService.saveNotificationTemplate(templateRequest);
		log.info("Notification Template saved");
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	@PutMapping("/updateNotificationTemplate/{id}")
	@Transactional
	public ResponseEntity<SuccessResponse> updateNotificationTemplate(
			@RequestBody NotificationTemplateRequest templateRequest, @PathVariable("id") Long id)
			throws TemplateNotFound {
		if (templateRequest == null) {
			throw new TemplateNotFound("Request body should not be blank");
		}
		SuccessResponse successResponse = templateService.updateNotificationTemplate(templateRequest, id);
		log.info("Notification Template Updated Id = " + id);
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	@GetMapping("/listNotificationTemplate")
	public ResponseEntity<TemplateListResponse> getAllList() {
		TemplateListResponse list = templateService.getAllList();
		log.info("Notification Template List Fetched Successfully");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("deleteNotificationTemplate/{id}")
	public ResponseEntity<SuccessResponse> deleteNotificationTemplate(@PathVariable("id") Long id)
			throws TemplateNotFound {
		SuccessResponse successResponse = templateService.deleteNotificationTemplate(id);
		log.info("Notification Template Deleted Id = " + id);
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}
}
