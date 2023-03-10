package com.indusnet.notification.dto;

import java.util.Date;
import com.indusnet.notification.common.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationTemplateRequest {

	private Long id;
	private NotificationType notificationType;
	private String type;
	private Date templateValidUpto;
	private String subject;
	private String bodyMessage;
	private String requestDevice;

}
