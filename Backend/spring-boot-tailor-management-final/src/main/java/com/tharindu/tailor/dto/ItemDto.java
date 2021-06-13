package com.tharindu.tailor.dto;

import java.io.Serializable;
import java.util.Date;

public class ItemDto implements Serializable {


	private static final long serialVersionUID = 7511276936570756849L;
	
	private long id;
	private String publicOrderId;
	private String publicItemId;
	private char status;
	private int quantity;
	private Date sewDate;
	private Date fitonDate;
	private OrderDto order;
	private String owner;
	private EmployeeDto employeeDto;
	private String associateCustomerMobile;
	private String associateCustomerFirstName;
	private String associatedEmpName;
	private String associatedEmpMobile;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
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
	public OrderDto getOrder() {
		return order;
	}
	public void setOrder(OrderDto order) {
		this.order = order;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getFitonDate() {
		return fitonDate;
	}
	public void setFitonDate(Date fitonDate) {
		this.fitonDate = fitonDate;
	}
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
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
	public String getPublicOrderId() {
		return publicOrderId;
	}
	public void setPublicOrderId(String publicOrderId) {
		this.publicOrderId = publicOrderId;
	}
	public String getAssociatedEmpMobile() {
		return associatedEmpMobile;
	}
	public void setAssociatedEmpMobile(String associatedEmpMobile) {
		this.associatedEmpMobile = associatedEmpMobile;
	}
	
	
}
