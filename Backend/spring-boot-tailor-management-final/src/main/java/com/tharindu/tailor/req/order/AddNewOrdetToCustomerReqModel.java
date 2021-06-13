package com.tharindu.tailor.req.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.tharindu.tailor.dto.ItemDto;

public class AddNewOrdetToCustomerReqModel {
	
	private String orderOwnerMobile;
	private Date dateCreated;
	private Date deliveryDate;
	private BigDecimal advance;
	private char type;
	private char orderStatus;
	private BigDecimal total;
	private List<ItemDto> items;
	
	
	public String getOrderOwnerMobile() {
		return orderOwnerMobile;
	}
	public void setOrderOwnerMobile(String orderOwnerMobile) {
		this.orderOwnerMobile = orderOwnerMobile;
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
	public List<ItemDto> getItems() {
		return items;
	}
	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

	
	
}
