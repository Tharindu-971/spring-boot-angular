package com.tharindu.tailor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tharindu.tailor.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	EmployeeEntity findByPublicEmpId(String employeeId);

	EmployeeEntity findByEmpMobile(String mobile);
}
