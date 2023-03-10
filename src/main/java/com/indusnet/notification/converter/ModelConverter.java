package com.indusnet.notification.converter;

import com.indusnet.notification.dto.NotificationTemplateRequest;
import com.indusnet.notification.dto.NotificationTemplateResponse;
import com.indusnet.notification.entity.NotificationTemplateEntity;

public class ModelConverter {

	private ModelConverter() {

	}

	public static NotificationTemplateEntity dtoToEntity(NotificationTemplateRequest templateRequest) {

		NotificationTemplateEntity templateEntity = new NotificationTemplateEntity();

		templateEntity.setNotificationType(templateRequest.getNotificationType());
		templateEntity.setType(templateRequest.getType());
		templateEntity.setTemplateValidUpto(templateRequest.getTemplateValidUpto());
		templateEntity.setSubject(templateRequest.getSubject());
		templateEntity.setBodyMessage(templateRequest.getBodyMessage());
		templateEntity.setRequestDevice(templateRequest.getRequestDevice());
		templateEntity.setStatus(true);
		templateEntity.setArchive(false);

		return templateEntity;
	}

	public static NotificationTemplateResponse entityToDTO(NotificationTemplateEntity templateEntity) {

		NotificationTemplateResponse templateResponse = new NotificationTemplateResponse();

		templateResponse.setId(templateEntity.getId());
		templateResponse.setNotificationType(templateEntity.getNotificationType());
		templateResponse.setType(templateEntity.getType());
		templateResponse.setTemplateValidUpto(templateEntity.getTemplateValidUpto());
		templateResponse.setSubject(templateEntity.getSubject());
		templateResponse.setBodyMessage(templateEntity.getBodyMessage());
		templateResponse.setRequestDevice(templateEntity.getRequestDevice());
		templateResponse.setCreatedDate(templateEntity.getCreatedDate());
		templateResponse.setLastModifiedDate(templateEntity.getLastModifiedDate());
		templateResponse.setStatus(templateEntity.getStatus());
		templateResponse.setArchive(templateEntity.getArchive());

		return templateResponse;
	}
}
