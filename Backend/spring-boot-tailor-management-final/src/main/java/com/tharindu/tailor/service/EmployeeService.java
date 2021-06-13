package com.tharindu.tailor.service;

import java.util.List;

import com.tharindu.tailor.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(EmployeeDto employeeDto);
	List<EmployeeDto> getAllEmployee();
}
