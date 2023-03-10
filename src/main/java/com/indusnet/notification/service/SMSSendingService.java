package com.indusnet.notification.service;

import com.indusnet.notification.dto.SMSSendingRequest;
import com.indusnet.notification.dto.SuccessResponse;

public interface SMSSendingService {

	SuccessResponse sendSMS(SMSSendingRequest sendingRequest);

}
