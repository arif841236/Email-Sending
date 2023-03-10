package com.indusnet.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileUploadSuccessResponse {

	private Integer status;
	private String message;
	private String[] attachedFile;
}
