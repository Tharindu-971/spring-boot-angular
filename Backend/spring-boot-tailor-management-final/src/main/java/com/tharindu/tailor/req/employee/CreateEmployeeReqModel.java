package com.tharindu.tailor.req.employee;

import java.util.Date;

public class CreateEmployeeReqModel {
	private String empFirstName;
	private String empLastName;
	private String empMobile;
	private String empEmail;
	private Date empDateCreated;
	private String empPassword;
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
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
	
	
}
