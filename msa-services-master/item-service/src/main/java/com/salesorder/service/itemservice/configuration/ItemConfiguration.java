package com.salesorder.service.itemservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="item-service")
@Component
public class ItemConfiguration {
	
	private String defaultItemName;
	
	private String defaultItemDesc;
	
	private int defaultItemPrice;

	public String getDefaultItemName() {
		return defaultItemName;
	}

	public void setDefaultItemName(String defaultItemName) {
		this.defaultItemName = defaultItemName;
	}

	public String getDefaultItemDesc() {
		return defaultItemDesc;
	}

	public void setDefaultItemDesc(String defaultItemDesc) {
		this.defaultItemDesc = defaultItemDesc;
	}

	public int getDefaultItemPrice() {
		return defaultItemPrice;
	}

	public void setDefaultItemPrice(int defaultItemPrice) {
		this.defaultItemPrice = defaultItemPrice;
	}
	
	

}
