package com.tharindu.tailor.req.item;

import java.util.Date;

public class UpdateItemReqModel {
	
	private String publicItemId;
	private char status;
	private int quantity;
	private Date sewDate;
	private Date fitonDate;
	private String owner;
	private String associatedEmpMobile;
	
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
	public String getAssociatedEmpMobile() {
		return associatedEmpMobile;
	}
	public void setAssociatedEmpMobile(String associatedEmpMobile) {
		this.associatedEmpMobile = associatedEmpMobile;
	}

	
	
}
