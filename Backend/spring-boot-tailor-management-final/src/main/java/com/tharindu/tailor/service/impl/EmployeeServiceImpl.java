package com.tharindu.tailor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tharindu.tailor.dao.EmployeeRepository;
import com.tharindu.tailor.dto.EmployeeDto;
import com.tharindu.tailor.entity.EmployeeEntity;
import com.tharindu.tailor.service.EmployeeService;
import com.tharindu.tailor.shared.Utils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private Utils publicId;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		ModelMapper modelMapper = new ModelMapper();

		if (employeeRepository.findByEmpMobile(employeeDto.getEmpMobile()) != null) {
			return null;
		} else {
			employeeDto.setPublicEmpId(publicId.publicId(30));
			EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);

			EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);

			EmployeeDto returnValue = modelMapper.map(savedEmployee, EmployeeDto.class);

			return returnValue;
		}
	}

	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {

		EmployeeEntity employee = employeeRepository.findByEmpMobile(employeeDto.getEmpMobile());
		ModelMapper modelMapper = new ModelMapper();

		if (employee != null) {
			employee.setEmpFirstName(employeeDto.getEmpFirstName());
			employee.setEmpLastName(employeeDto.getEmpLastName());
			employee.setEmpMobile(employeeDto.getEmpMobile());
			employee.setEmpEmail(employeeDto.getEmpEmail());
			EmployeeEntity updatedEmployee = employeeRepository.save(employee);
			EmployeeDto empDto = modelMapper.map(updatedEmployee, EmployeeDto.class);
			return empDto;
		} else {
			return null;
		}

	}

	@Override
	public List<EmployeeDto> getAllEmployee() {

		List<EmployeeDto> employeesDto = new ArrayList<EmployeeDto>();
		List<EmployeeEntity> employees = employeeRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();

		if (!employees.isEmpty()) {
			for (EmployeeEntity employee : employees) {
				EmployeeDto empDto = modelMapper.map(employee, EmployeeDto.class);
				employeesDto.add(empDto);
			}
			return employeesDto;
		} else {
			return null;
		}
	}

	public EmployeeDto getEmployeeByMobile(EmployeeDto employeeDto) {

		EmployeeEntity employeeEntity = employeeRepository.findByEmpMobile(employeeDto.getEmpMobile());
		ModelMapper modelMapper = new ModelMapper();

		if (employeeEntity != null) {
			EmployeeDto returnValue = modelMapper.map(employeeEntity, EmployeeDto.class);
			return returnValue;
		}
		return null;
	}

	public ResponseEntity<Object> deleteByMobile(EmployeeDto employeeDto) {

		EmployeeEntity employee = employeeRepository.findByEmpMobile(employeeDto.getEmpMobile());
		if (employee != null) {
			employeeRepository.delete(employee);
			return ResponseEntity.ok().body("Delete Successfully");
		} else {
			return ResponseEntity.ok().body("Delete falied");
		}
	}

}
