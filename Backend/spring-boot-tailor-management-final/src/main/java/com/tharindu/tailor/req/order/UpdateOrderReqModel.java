package com.tharindu.tailor.req.order;

import java.math.BigDecimal;
import java.util.Date;

import com.tharindu.tailor.dto.CustomerDto;

public class UpdateOrderReqModel {
	
	private String publicOrderId;
	private Date deliveryDate;
	private BigDecimal advance;
	private char type;
	private char orderStatus;
	private BigDecimal total;
	public String getPublicOrderId() {
		return publicOrderId;
	}
	public void setPublicOrderId(String publicOrderId) {
		this.publicOrderId = publicOrderId;
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
	
	
}
