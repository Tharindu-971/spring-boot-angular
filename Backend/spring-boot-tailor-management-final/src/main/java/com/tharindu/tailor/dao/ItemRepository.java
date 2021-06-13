package com.tharindu.tailor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tharindu.tailor.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{
	ItemEntity findByPublicItemId(String publicItemId); 
}
