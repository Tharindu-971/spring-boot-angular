package com.tharindu.tailor.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tharindu.tailor.dto.EmployeeDto;
import com.tharindu.tailor.req.employee.CreateEmployeeReqModel;
import com.tharindu.tailor.req.employee.UpdateEmployeeReqModel;
import com.tharindu.tailor.res.model.EmployeeResModel;
import com.tharindu.tailor.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@PostMapping("/employee")
	public ResponseEntity<Object> createCustomer(@RequestBody CreateEmployeeReqModel employee) {

		ModelMapper modelMapper = new ModelMapper();
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		
		EmployeeDto savedEmployee = employeeServiceImpl.createEmployee(employeeDto);

		HttpHeaders headers = new HttpHeaders();

		if (savedEmployee != null) {

			EmployeeResModel empRes = modelMapper.map(savedEmployee, EmployeeResModel.class);

			headers.add("Responded", "employee create successfull");

			return ResponseEntity.accepted().body(empRes);
		} else {
			headers.add("Responded", "emplyee create fail");
			return ResponseEntity.unprocessableEntity().body("employee create fail");
		}
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Object> updateEmployee(@RequestBody UpdateEmployeeReqModel updateEmployee){
		ModelMapper modelMapper = new ModelMapper();
		EmployeeDto employeeDto = modelMapper.map(updateEmployee, EmployeeDto.class);

		EmployeeDto updatedEmployee = employeeServiceImpl.updateEmployee(employeeDto);
		
		
		HttpHeaders headers = new HttpHeaders();
		if (updatedEmployee != null) {

			EmployeeResModel empRes = modelMapper.map(updatedEmployee, EmployeeResModel.class);

			headers.add("Responded", "employee update successfull");

			return ResponseEntity.accepted().body(empRes);
		} else {
			headers.add("Responded", "employee not found");
			return ResponseEntity.unprocessableEntity().body("employee not found");
		}

	}
	
	@GetMapping("/employee")
	public ResponseEntity<Object> getEmployees(){
		
		List<EmployeeResModel> employeeRes = new ArrayList<EmployeeResModel>();
		List<EmployeeDto> employeesDto = employeeServiceImpl.getAllEmployee();
		
		ModelMapper modelMapper = new ModelMapper();
		HttpHeaders headers = new HttpHeaders();
		if (employeesDto != null) {
			for(EmployeeDto employee : employeesDto) {
				EmployeeResModel empRes = modelMapper.map(employee, EmployeeResModel.class);
				employeeRes.add(empRes);
			}
			

			headers.add("Responded", "all employees");

			return ResponseEntity.accepted().body(employeeRes);
		} else {
			headers.add("Responded", "employees empty");
			return ResponseEntity.unprocessableEntity().body("employees empty");
		}
	}
	
	
	@GetMapping("/employee/{mobile}")
	public ResponseEntity<Object> getEmployeeByMobile(@PathVariable String mobile){
		ModelMapper modelMapper = new ModelMapper();
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmpMobile(mobile);
		
		EmployeeDto employee = employeeServiceImpl.getEmployeeByMobile(employeeDto);

		HttpHeaders headers = new HttpHeaders();
		if (employee != null) {
			
			EmployeeResModel empRes = modelMapper.map(employee, EmployeeResModel.class);
			headers.add("Responded", "employee with id");
			return ResponseEntity.accepted().body(empRes);
		} else {
			headers.add("Responded", "employees not found");
			return ResponseEntity.unprocessableEntity().body("employees not found");
		}
	}
	
	@DeleteMapping("employee/{mobile}")
	public ResponseEntity<Object> deleteByMobile(@PathVariable String mobile){

		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmpMobile(mobile);
		
		return employeeServiceImpl.deleteByMobile(employeeDto);
	}
}
