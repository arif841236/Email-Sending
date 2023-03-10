package com.indusnet.notification.dto;

import java.util.List;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SMSSendingRequest {

	private String notificationType;
	private String type;
	private Long notificationTemplateId;
	@OneToMany
	private List<SMSNotifyTo> notifyTo;

}
