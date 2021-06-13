package com.tharindu.tailor.service;

import java.util.List;

import com.tharindu.tailor.dto.ItemDto;
import com.tharindu.tailor.dto.OrderDto;

public interface ItemService {
	
	//ItemDto addEmployeeToItem(AddEmployeeToItem empToIte);
	//OrderDto addNewItemsToOrder(OrderDto orderDto);
	List<ItemDto> addNewItemsToOrder(List<ItemDto> orderDto) ;
}
