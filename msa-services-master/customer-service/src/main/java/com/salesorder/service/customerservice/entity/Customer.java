package com.salesorder.service.customerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_SOS")
public class Customer {
	
	@Id
	@Column(name="cust_id")
	private Long customerId;
	
	@Column(name="cust_email")
	private String email;
	
	@Column(name="cust_first_name")
	private String firstName;
	
	@Column(name="cust_last_name")
	private String lastName;
	
	public Customer() {
	}

	public Customer(Long id, String email, String firstName, String lastName) {
		this.customerId = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long id) {
		this.customerId = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
