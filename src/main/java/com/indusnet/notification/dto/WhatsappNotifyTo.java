package com.indusnet.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WhatsappNotifyTo {

	private Integer id;
	private String name;
	private String phone;

}
