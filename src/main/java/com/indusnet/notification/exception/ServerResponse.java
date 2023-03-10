package com.indusnet.notification.exception;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServerResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String status;
	private Integer errorCode;
	private String errorMessage;
	private String traceID;
	private String errorDetails;
	private String path;

}