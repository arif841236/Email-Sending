package com.indusnet.notification.common;

public enum NotificationType {
	EMAIL("EMAIL"), SMS("SMS"), WHATSAPP("WHATSAPP"), INAPP("INAPP");

	private final String value;

	private NotificationType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static String get(String type) {
		for (NotificationType v : values()) {
			if (v.name().equals(type)) {
				return v.getValue();
			}
		}
		return null;
	}
}