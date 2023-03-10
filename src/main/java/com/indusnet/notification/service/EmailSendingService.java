package com.indusnet.notification.service;

import com.indusnet.notification.dto.EmailSendingRequest;
import com.indusnet.notification.dto.SuccessResponse;

public interface EmailSendingService {

	public SuccessResponse sendEmail(EmailSendingRequest sendingRequest);

}
