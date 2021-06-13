package com.tharindu.tailor.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharindu.tailor.dao.EmployeeRepository;
import com.tharindu.tailor.dao.ItemRepository;
import com.tharindu.tailor.dao.OrderRepository;
import com.tharindu.tailor.dto.EmployeeDto;
import com.tharindu.tailor.dto.ItemDto;
import com.tharindu.tailor.dto.OrderDto;
import com.tharindu.tailor.entity.EmployeeEntity;
import com.tharindu.tailor.entity.ItemEntity;
import com.tharindu.tailor.entity.OrderEntity;
import com.tharindu.tailor.res.model.ItemResModel;
import com.tharindu.tailor.service.ItemService;
import com.tharindu.tailor.shared.Utils;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private Utils publicId;

	@Override
	public List<ItemDto> addNewItemsToOrder(List<ItemDto> itemsDto) {
		List<ItemDto> returnItems = new ArrayList<ItemDto>();
		ModelMapper modelMapper = new ModelMapper();
		if(itemsDto.isEmpty()) {
			return null;
		}
		if(orderRepository.findByPublicOrderId(itemsDto.get(0).getPublicOrderId()) != null) {
			OrderEntity orderEntity = orderRepository.findByPublicOrderId(itemsDto.get(0).getPublicOrderId());
			OrderDto orderDto = modelMapper.map(orderEntity, OrderDto.class);
			
			for(int i = 0 ; i<itemsDto.size(); i++) {
				ItemDto itemDto = itemsDto.get(i);
				itemDto.setPublicItemId(publicId.publicId(30));
				itemDto.setOrder(orderDto);
				itemDto.setAssociateCustomerFirstName(orderDto.getCustomer().getFirstName());
				itemDto.setAssociateCustomerMobile(orderDto.getCustomer().getMobile());
				
				ItemEntity itemEntity = modelMapper.map(itemDto,ItemEntity.class);
				itemRepository.save(itemEntity);
				returnItems.add(itemDto);
			}
			return returnItems;
		}else {
			return null;
		}
		
	}
	
	public ItemDto updateItem(ItemDto itemDto) {
		
		ItemEntity itemEntity = itemRepository.findByPublicItemId(itemDto.getPublicItemId());
		EmployeeEntity employeeEntity = new EmployeeEntity();
		ModelMapper modelMapper = new ModelMapper();
		
		if(itemEntity != null ) {
			if(itemDto.getAssociatedEmpMobile() != null) {
				employeeEntity = employeeRepository.findByEmpMobile(itemDto.getAssociatedEmpMobile());
				itemEntity.setEmployee(employeeEntity);
			}
			
			itemEntity.setFitonDate(itemDto.getFitonDate());
			itemEntity.setOwner(itemDto.getOwner());
			itemEntity.setQuantity(itemDto.getQuantity());
			itemEntity.setSewDate(itemDto.getSewDate());
			itemEntity.setStatus(itemDto.getStatus());
			
			ItemEntity updatedEmployee = itemRepository.save(itemEntity);
			
			ItemDto returnValue = modelMapper.map(updatedEmployee, ItemDto.class);
			returnValue.setAssociateCustomerFirstName(itemEntity.getOrder().getCustomer().getFirstName());
			returnValue.setAssociateCustomerMobile(itemEntity.getOrder().getCustomer().getMobile());
			returnValue.setAssociatedEmpName(employeeEntity.getEmpMobile());
			returnValue.setAssociatedEmpMobile(employeeEntity.getEmpMobile());
			return returnValue;
		}else {
			return null;
		}

	}
	
	public List<ItemDto> getAllItems(){
		List<ItemDto> itemsDto = new ArrayList<ItemDto>();
		List<ItemEntity> itemsEntity = itemRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		
		
		if(!itemsEntity.isEmpty()) {
			for(ItemEntity entity : itemsEntity) {
				EmployeeEntity emp = entity.getEmployee();
				
				ItemDto item = modelMapper.map(entity, ItemDto.class);
				item.setAssociateCustomerFirstName(entity.getOrder().getCustomer().getFirstName());
				item.setAssociateCustomerMobile(entity.getOrder().getCustomer().getMobile());
				
				if(emp!= null) {
				item.setAssociatedEmpName(entity.getEmployee().getEmpFirstName());
				}
				itemsDto.add(item);
			}
			return itemsDto;
		}else {
			return null;
		}
		
		
	}
}

