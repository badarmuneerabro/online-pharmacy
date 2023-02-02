package com.pharmacy.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order 
{
	private int orderId;
	private String userEmail;
	private String orderDate;
	private int orderStatus;
	private double totalPrice;
	private String items;
	
	public Order() {
		
		super();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		orderDate = format.format(date);
	}
	
	public Order(int orderId, String userEmail, String orderDate, int orderStatus) {
		super();
		this.orderId = orderId;
		this.userEmail = userEmail;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}
	
	
}
