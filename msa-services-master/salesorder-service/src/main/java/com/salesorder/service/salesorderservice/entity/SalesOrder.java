package com.salesorder.service.salesorderservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sales_order")
public class SalesOrder {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="cust_id")
	private Long customerId;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="order_desc")
	private String orderDesc;
	
	@Column(name="total_price")
	private int itemPrice;

	public SalesOrder() {
	}

	public SalesOrder(Long orderId, Long customerId, Date orderDate, String orderDesc, int totalPrice) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.orderDesc = orderDesc;
		this.itemPrice = totalPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int totalPrice) {
		this.itemPrice = totalPrice;
	}
	
    
}
