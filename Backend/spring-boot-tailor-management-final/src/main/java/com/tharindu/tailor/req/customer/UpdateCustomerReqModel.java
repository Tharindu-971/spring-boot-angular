package com.tharindu.tailor.req.customer;

public class UpdateCustomerReqModel {
	
	private String publicCustomerId;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	
	
	public String getPublicCustomerId() {
		return publicCustomerId;
	}
	public void setPublicCustomerId(String publicCustomerId) {
		this.publicCustomerId = publicCustomerId;
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
	
	
}
