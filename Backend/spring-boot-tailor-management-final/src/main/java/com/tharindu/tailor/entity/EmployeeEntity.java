package com.tharindu.tailor.entity;

import java.io.Serializable;
import java.util.Date;
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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable{

	private static final long serialVersionUID = 5331345582757054155L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "public_emp_id")
	private String publicEmpId;
	
	@Column(name = "emp_first_name")
	private String empFirstName;
	
	@Column(name = "emp_last_name")
	private String empLastName;
	
	@Column(name = "emp_mobile", nullable = false, unique = true)
	private String empMobile;
	
	@Column(name = "emp_email")
	private String empEmail;
	
	@Column(name = "emp_created")
	@CreationTimestamp
	private Date empDateCreated;
	
	
	@OneToMany(targetEntity = OrderEntity.class, cascade = {CascadeType.DETACH,CascadeType.MERGE,
															CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "employee_id")
	private List<ItemEntity> items;
	
	@Column(name = "emp_encrypted_password")
	private String encryptedPassword;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmpFirstName() {
		return empFirstName;
	}


	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}


	public String getEmpLastName() {
		return empLastName;
	}


	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}


	public String getEmpMobile() {
		return empMobile;
	}


	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}


	public String getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}


	public Date getEmpDateCreated() {
		return empDateCreated;
	}


	public void setEmpDateCreated(Date empDateCreated) {
		this.empDateCreated = empDateCreated;
	}


	public List<ItemEntity> getItems() {
		return items;
	}


	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}


	public String getEncryptedPassword() {
		return encryptedPassword;
	}


	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}


	public String getPublicEmpId() {
		return publicEmpId;
	}


	public void setPublicEmpId(String publicEmpId) {
		this.publicEmpId = publicEmpId;
	}


	
	
}
