package com.indusnet.notification.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.indusnet.notification.common.NotificationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "email_sending")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationTemplateEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "notification_type", nullable = false)
	private NotificationType notificationType;

	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "template_valid_upto")
	private Date templateValidUpto;

	@Column(name = "subject")
	private String subject;

	@Column(name = "body_message", length = 65535, columnDefinition = "text", nullable = false)
	private String bodyMessage;

	@Column(name = "request_device", nullable = false)
	private String requestDevice;

	@Column(name = "created_date", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdDate;

	@Column(name = "last_modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date lastModifiedDate;

	@Column(columnDefinition = "boolean default true")
	Boolean status;

	@Column(columnDefinition = "boolean default false")
	Boolean archive;
}
