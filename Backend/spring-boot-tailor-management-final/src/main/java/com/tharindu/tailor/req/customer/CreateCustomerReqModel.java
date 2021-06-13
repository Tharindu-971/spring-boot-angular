package com.tharindu.tailor.req.customer;

import java.util.List;

import com.tharindu.tailor.dto.OrderDto;

public class CreateCustomerReqModel {
	
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private List<OrderDto> orders;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<OrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	
	
}




