package com.tharindu.tailor.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.tharindu.tailor.entity.CustomerEntity;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
	public CustomerEntity findByEmail(String email);

	public CustomerEntity findByPublicCustomerId(String publicCustomerId);

	public CustomerEntity findByMobile(String mobile);
}
