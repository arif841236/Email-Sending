package com.indusnet.notification.dto;

import java.util.List;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailSendingRequest {

	private String notificationType;
	private String type;
	private Long notificationTemplateId;
	private String[] cc;
	private String[] bcc;
	private String[] attachedFile;
	@OneToMany
	private List<EmailNotifyTo> notifyTo;

}
