package com.tharindu.tailor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item")
public class ItemEntity implements Serializable{

	private static final long serialVersionUID = 1003011400819632274L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "public_item_id", unique = true, nullable = false)
	private String publicItemId;
	
	@Column(name = "status")
	private char status;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "sew_date")
	private Date sewDate;
	
	@Column(name = "fiton_date")
	private Date fitonDate;
	
	@Column(name = "owner")
	private String owner;
	
	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JsonIgnore
	private OrderEntity order;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JsonIgnore
	private EmployeeEntity employee;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
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
	public EmployeeEntity getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	public String getPublicItemId() {
		return publicItemId;
	}
	public void setPublicItemId(String publicItemId) {
		this.publicItemId = publicItemId;
	}
	
	
}
