package com.tharindu.tailor.req.item;

import java.util.Date;

import com.tharindu.tailor.dto.EmployeeDto;
import com.tharindu.tailor.dto.OrderDto;

public class AddNewItemToExistingOrderReqModel {
	
	private char status;
	private int quantity;
	private Date sewDate;
	private Date fitonDate;
	private String owner;
	private String publicOrderId;
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getSewDate() {
		return sewDate;
	}
	public void setSewDate(Date sewDate) {
		this.sewDate = sewDate;
	}
	public Date getFitonDate() {
		return fitonDate;
	}
	public void setFitonDate(Date fitonDate) {
		this.fitonDate = fitonDate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPublicOrderId() {
		return publicOrderId;
	}
	public void setPublicOrderId(String publicOrderId) {
		this.publicOrderId = publicOrderId;
	}
	
	
}
