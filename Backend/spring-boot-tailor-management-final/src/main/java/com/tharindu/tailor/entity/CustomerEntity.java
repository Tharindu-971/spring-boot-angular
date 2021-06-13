package com.tharindu.tailor.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable{

	private static final long serialVersionUID = 6223406906417464468L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "public_customer_id", unique = true, nullable = false)
	private String publicCustomerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "mobile", unique = true)
	private String mobile;
	
	@Column(name = "email",unique = true)
	private String email;
	

	@OneToMany(targetEntity = OrderEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<OrderEntity> orders;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<OrderEntity> getOrders() {	
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public String getPublicCustomerId() {
		return publicCustomerId;
	}

	public void setPublicCustomerId(String publicCustomerId) {
		this.publicCustomerId = publicCustomerId;
	}
	
}
