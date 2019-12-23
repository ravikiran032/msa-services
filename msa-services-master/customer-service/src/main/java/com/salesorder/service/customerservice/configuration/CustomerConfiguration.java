package com.salesorder.service.customerservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="customer-service")
@Component
public class CustomerConfiguration {
   
	private String defaultFirstname;
	
	private String defaultLastname;
	
	private String defaultEmail;

	public String getDefaultFirstname() {
		return defaultFirstname;
	}

	public void setDefaultFirstname(String defaultFirstname) {
		this.defaultFirstname = defaultFirstname;
	}

	public String getDefaultLastname() {
		return defaultLastname;
	}

	public void setDefaultLastname(String defaultLastname) {
		this.defaultLastname = defaultLastname;
	}

	public String getDefaultEmail() {
		return defaultEmail;
	}

	public void setDefaultEmail(String defaultEmail) {
		this.defaultEmail = defaultEmail;
	}
	
}
