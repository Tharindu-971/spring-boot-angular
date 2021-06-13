package com.tharindu.tailor.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class OrderDto implements Serializable{
	

	private static final long serialVersionUID = 4272438663782373069L;
	private long id;
	private String publicOrderId;
	private Date dateCreated;
	private Date deliveryDate;
	private BigDecimal advance;
	private char type;
	private char orderStatus;
	private BigDecimal total;
	private CustomerDto customer;
	private List<ItemDto> items;
	private String orderOwnerMobile;
	private String orderOwnerFirstName;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

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
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public List<ItemDto> getItems() {
		return items;
	}
	public void setItems(List<ItemDto> items) {
		this.items = items;
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
