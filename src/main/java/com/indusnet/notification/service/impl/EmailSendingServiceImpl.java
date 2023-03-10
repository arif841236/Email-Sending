package com.indusnet.notification.service.impl;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.indusnet.notification.dto.EmailSendingRequest;
import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.entity.NotificationTemplateEntity;
import com.indusnet.notification.service.EmailSendingService;
import com.indusnet.notification.service.NotificationTemplateService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailSendingServiceImpl implements EmailSendingService {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private NotificationTemplateService templateService;

	@Override
	public SuccessResponse sendEmail(EmailSendingRequest sendingRequest) {

		Long notificationTemplateId = sendingRequest.getNotificationTemplateId();
		NotificationTemplateEntity template = templateService.getTemplate(notificationTemplateId);
		log.info(template.getSubject());
		sendingRequest.getNotifyTo().forEach(x -> {
			try {
				String msg = template.getBodyMessage().replace("{{#name}}", x.getName());
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setTo(x.getEmail());
				helper.setText(msg);
				helper.setSubject(template.getSubject());
				helper.setCc(sendingRequest.getCc());
				helper.setBcc(sendingRequest.getBcc());

				for (int i = 0; i < sendingRequest.getAttachedFile().length; i++) {
					FileSystemResource filesystemResorce = new FileSystemResource(
							new File(sendingRequest.getAttachedFile()[i]));
					helper.addAttachment(filesystemResorce.getFilename(), filesystemResorce);
				}
				sender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		});
		return SuccessResponse.builder().status(HttpStatus.OK.value()).message("Email Notification Send Successfully")
				.templateId(notificationTemplateId).build();
	}
}
