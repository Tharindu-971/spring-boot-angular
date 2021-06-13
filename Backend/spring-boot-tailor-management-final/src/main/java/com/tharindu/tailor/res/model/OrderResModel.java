package com.tharindu.tailor.res.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.tharindu.tailor.dto.CustomerDto;
import com.tharindu.tailor.dto.ItemDto;

public class OrderResModel {
	
	private String publicOrderId;
	private Date dateCreated;
	private Date deliveryDate;
	private BigDecimal advance;
	private char type;
	private char orderStatus;
	private BigDecimal total;
	private String orderOwnerMobile;
	private String orderOwnerFirstName;
	
	public String getPublicOrderId() {
		return publicOrderId;
	}
	public void setPublicOrderId(String publicOrderId) {
		this.publicOrderId = publicOrderId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public BigDecimal getAdvance() {
		return advance;
	}
	public void setAdvance(BigDecimal advance) {
		this.advance = advance;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public char getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(char orderStatus) {
		this.orderStatus = orderStatus;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getOrderOwnerMobile() {
		return orderOwnerMobile;
	}
	public void setOrderOwnerMobile(String orderOwnerMobile) {
		this.orderOwnerMobile = orderOwnerMobile;
	}
	public String getOrderOwnerFirstName() {
		return orderOwnerFirstName;
	}
	public void setOrderOwnerFirstName(String orderOwnerFirstName) {
		this.orderOwnerFirstName = orderOwnerFirstName;
	}
	
	
}
