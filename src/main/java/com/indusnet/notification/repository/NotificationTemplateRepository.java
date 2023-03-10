package com.indusnet.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.notification.entity.NotificationTemplateEntity;

@Repository
public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplateEntity, Long> {

	public NotificationTemplateEntity getTemplateById(Long id);

}
