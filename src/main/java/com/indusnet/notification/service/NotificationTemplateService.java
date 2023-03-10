package com.indusnet.notification.service;

import com.indusnet.notification.dto.NotificationTemplateRequest;
import com.indusnet.notification.dto.SuccessResponse;
import com.indusnet.notification.dto.TemplateListResponse;
import com.indusnet.notification.entity.NotificationTemplateEntity;
import com.indusnet.notification.exception.TemplateNotFound;

public interface NotificationTemplateService {

	public SuccessResponse saveNotificationTemplate(NotificationTemplateRequest templateRequest)
			throws TemplateNotFound;

	public SuccessResponse updateNotificationTemplate(NotificationTemplateRequest templateRequest, Long id)
			throws TemplateNotFound;

	public TemplateListResponse getAllList();

	public NotificationTemplateEntity getTemplate(Long id);

	public SuccessResponse deleteNotificationTemplate(Long id) throws TemplateNotFound;

}
