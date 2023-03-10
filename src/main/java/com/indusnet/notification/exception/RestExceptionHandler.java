package com.indusnet.notification.exception;

import java.time.LocalDateTime;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotificationSendingException.class)
	protected ResponseEntity<Object> handleEntityNotFound(NotificationSendingException ex) {
		ServerResponse serverError = new ServerResponse();
		serverError.setTimestamp(LocalDateTime.now());
		serverError.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		serverError.setErrorCode(500);
		serverError.setErrorMessage(ex.getMessage());
		serverError.setTraceID("");
		serverError.setErrorDetails(ex.getLocalizedMessage());
		serverError.setPath("");
		return buildResponseEntity(serverError);
	}

	@ExceptionHandler(TemplateNotFound.class)
	protected ResponseEntity<Object> handleEntityNotFound(TemplateNotFound ex) {
		ServerResponse serverError = new ServerResponse();
		serverError.setTimestamp(LocalDateTime.now());
		serverError.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		serverError.setErrorCode(500);
		serverError.setErrorMessage(ex.getMessage());
		serverError.setTraceID("");
		serverError.setErrorDetails(ex.getLocalizedMessage());
		serverError.setPath("");
		return buildResponseEntity(serverError);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	protected ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		ServerResponse serverError = new ServerResponse();
		serverError.setTimestamp(LocalDateTime.now());
		serverError.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		serverError.setErrorCode(500);
		serverError.setErrorMessage(ex.getMessage());
		serverError.setTraceID("");
		serverError.setErrorDetails(ex.getLocalizedMessage());
		serverError.setPath("");
		return buildResponseEntity(serverError);
	}

	private ResponseEntity<Object> buildResponseEntity(ServerResponse serverError) {
		return new ResponseEntity<>(serverError, HttpStatus.valueOf(serverError.getErrorMessage()));
	}
}