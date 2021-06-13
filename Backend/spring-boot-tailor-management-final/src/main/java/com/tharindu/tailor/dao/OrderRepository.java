package com.tharindu.tailor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tharindu.tailor.dto.OrderDto;
import com.tharindu.tailor.entity.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

	OrderEntity findByPublicOrderId(String publicOrderId);

}
