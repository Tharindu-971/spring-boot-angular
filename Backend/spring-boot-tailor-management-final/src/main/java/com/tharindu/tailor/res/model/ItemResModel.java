package com.tharindu.tailor.res.model;

import java.util.Date;

import com.tharindu.tailor.dto.EmployeeDto;
import com.tharindu.tailor.dto.OrderDto;

public class ItemResModel {
	
	private String publicItemId;
	private char status;
	private int quantity;
	private Date sewDate;
	private Date fitonDate;
	private String owner;
	private String associateCustomerMobile;
	private String associateCustomerFirstName;
	private String associatedEmpName;
	public String getPublicItemId() {
		return publicItemId;
	}
	public void setPublicItemId(String publicItemId) {
		this.publicItemId = publicItemId;
	}
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
	public String getAssociateCustomerMobile() {
		return associateCustomerMobile;
	}
	public void setAssociateCustomerMobile(String associateCustomerMobile) {
		this.associateCustomerMobile = associateCustomerMobile;
	}
	public String getAssociatedEmpName() {
		return associatedEmpName;
	}
	public void setAssociatedEmpName(String associatedEmpName) {
		this.associatedEmpName = associatedEmpName;
	}
	public String getAssociateCustomerFirstName() {
		return associateCustomerFirstName;
	}
	public void setAssociateCustomerFirstName(String associateCustomerFirstName) {
		this.associateCustomerFirstName = associateCustomerFirstName;
	}
	
	
}
