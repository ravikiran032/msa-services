package com.salesorder.service.salesorderservice.entity;

import java.util.Date;
import java.util.List;

public class Order {
  
	private String description;
	
	private Date date;
	
	private Long customerId;
	
	private List<String> itemNames;

	public Order() {
	}

	public Order(String description, Date date, Long customerId, List<String> itemNames) {
		this.description = description;
		this.date = date;
		this.customerId = customerId;
		this.itemNames = itemNames;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<String> getItemNames() {
		return itemNames;
	}

	public void setItemNames(List<String> itemNames) {
		this.itemNames = itemNames;
	}
	
	
}
