package com.indusnet.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.indusnet.notification.config.TwilioConfig;
import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.dto.WhatsappSendingRequest;
import com.indusnet.notification.entity.NotificationTemplateEntity;
import com.indusnet.notification.service.NotificationTemplateService;
import com.indusnet.notification.service.WhatsappSendingService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class WhatsappSendingServiceImpl implements WhatsappSendingService {
	
	@Autowired
	private NotificationTemplateService templateService;

	@Autowired
	private TwilioConfig twilioConfig;

	@Override
	public SuccessResponse sendWhatsapp(WhatsappSendingRequest sendingRequest) {
		NotificationTemplateEntity template = templateService.getTemplate(sendingRequest.getNotificationTemplateId());
		sendingRequest.getNotifyTo().forEach(x -> {
			Twilio.init(twilioConfig.getAccountSID(), twilioConfig.getAuthToken());
			String msg = template.getBodyMessage().replace("{{#name}}", x.getName());
			Message.creator(new PhoneNumber("whatsapp:"+x.getPhone()), new PhoneNumber("whatsapp:"+twilioConfig.getWhatsappTrialNumber()), msg)
					.create();
		});
		return SuccessResponse.builder().status(HttpStatus.OK.value()).message("Whatsapp Notification Send Successfully")
				.templateId(sendingRequest.getNotificationTemplateId()).build();
	
	}

}
