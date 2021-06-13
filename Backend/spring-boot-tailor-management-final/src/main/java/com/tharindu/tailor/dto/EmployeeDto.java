package com.tharindu.tailor.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EmployeeDto implements Serializable{

	private static final long serialVersionUID = -8762251751674224299L;
	
	private long id;
	private String publicEmpId;
	private String empFirstName;
	private String empLastName;
	private String empMobile;
	private String empEmail;
	private Date empDateCreated;
	private String password;
	private String encryptedPassword;
	private List<ItemDto> items;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getPublicEmpId() {
		return publicEmpId;
	}
	public void setPublicEmpId(String publicEmpId) {
		this.publicEmpId = publicEmpId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public List<ItemDto> getItems() {
		return items;
	}
	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
	
	
}
