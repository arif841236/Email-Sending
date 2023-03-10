package com.indusnet.notification.service;

import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.dto.WhatsappSendingRequest;

public interface WhatsappSendingService {

	SuccessResponse sendWhatsapp(WhatsappSendingRequest sendingRequest);

}
