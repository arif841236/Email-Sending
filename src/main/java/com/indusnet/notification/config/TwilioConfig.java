package com.indusnet.notification.config;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class TwilioConfig {

	private String accountSID = "AC14d442dc7967dd42cd0bedcf99fd404b";
	private String authToken = "7307bf4d8cb777e0bc4eb1ae1bfee981";
	private String smsTrialNumber = "+16509107946";
	private String whatsappTrialNumber = "+14155238886";

}
