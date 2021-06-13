package com.tharindu.tailor.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharindu.tailor.dao.CustomerRepository;
import com.tharindu.tailor.dto.CustomerDto;
import com.tharindu.tailor.dto.ItemDto;
import com.tharindu.tailor.dto.OrderDto;
import com.tharindu.tailor.entity.CustomerEntity;
import com.tharindu.tailor.res.model.CustomerResModel;
import com.tharindu.tailor.res.model.ItemResModel;
import com.tharindu.tailor.res.model.OrderResModel;
import com.tharindu.tailor.service.CustomerService;
import com.tharindu.tailor.shared.Utils;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private Utils publicId; 

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		
		if(customerRepository.findByEmail(customerDto.getEmail()) != null && 
				customerRepository.findByMobile(customerDto.getMobile()) != null)
			return null;

		for(int i = 0; i < customerDto.getOrders().size(); i++) {
			OrderDto orders = customerDto.getOrders().get(i);
			orders.setCustomer(customerDto);
			orders.setPublicOrderId(publicId.publicId(30));
			orders.setOrderOwnerMobile(customerDto.getMobile());
			
			for(int j = 0; j < orders.getItems().size(); j++) {
				ItemDto items = orders.getItems().get(j);
				items.setPublicItemId(publicId.publicId(30));
				items.setAssociateCustomerMobile(orders.getOrderOwnerMobile());
				items.setOwner(orders.getItems().get(j).getOwner());
				items.setOrder(orders);

				orders.getItems().set(j, items);
			}
			
			customerDto.getOrders().set(i, orders);
		}
		customerDto.setPublicCustomerId(publicId.publicId(30));
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
		
		CustomerEntity savedCustomer = customerRepository.save(customerEntity);
		
		CustomerDto returnValue = modelMapper.map(savedCustomer, CustomerDto.class);
		return returnValue;
	}
/*
	@Override
	public CustomerUpdateResModel updateCustomer(CustomerDto customerDto) {

		ModelMapper modelMapper = new ModelMapper();
		CustomerUpdateResModel customerUpdateResModel = new CustomerUpdateResModel();
		
		if(customerRepository.findByEmail(customerDto.getPublicCustomerId()) != null) {
			CustomerEntity customerEntity = customerRepository.findByEmail(customerDto.getEmail());
			customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
			CustomerEntity updatedCustomer = customerRepository.save(customerEntity);
			customerUpdateResModel = modelMapper.map(updatedCustomer, CustomerUpdateResModel.class);
		}
		
		return customerUpdateResModel;
	}
	*/
	@Override
	public List<ItemResModel> getAllItems(CustomerDto customerDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		CustomerDto customer = new CustomerDto();
		List<ItemResModel> returnValues = new ArrayList<ItemResModel>(); 
		
		if(customerRepository.findByMobile(customerDto.getMobile()) != null) {
			CustomerEntity customerEntity = customerRepository.findByMobile(customerDto.getMobile());
			
			customer = modelMapper.map(customerEntity, CustomerDto.class);
			
			for(int i = 0; i<customer.getOrders().size(); i++) {
				OrderDto orderDto =  customer.getOrders().get(i);
				orderDto.setOrderOwnerMobile(customer.getMobile());
				orderDto.setOrderOwnerFirstName(customer.getFirstName());
				
				for(int j = 0 ; j< orderDto.getItems().size(); j++) {
					ItemDto items = orderDto.getItems().get(j);
					items.setAssociateCustomerMobile(orderDto.getOrderOwnerMobile());
					items.setAssociateCustomerFirstName(orderDto.getOrderOwnerFirstName());
					if(items.getEmployeeDto() != null) {
						items.setAssociatedEmpName(items.getAssociatedEmpName());
					}
					ItemResModel resModel = modelMapper.map(items, ItemResModel.class);
					returnValues.add(resModel);
				}
			}
			
			return returnValues;
		}else {
			return null;
		}
		
		
	}
	
	@Override
	public List<OrderResModel> getAllOrders(CustomerDto customerDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		CustomerDto customer = new CustomerDto();
		List<OrderResModel> returnValues = new ArrayList<OrderResModel>(); 
		
		if(customerRepository.findByMobile(customerDto.getMobile()) != null) {
			CustomerEntity customerEntity = customerRepository.findByMobile(customerDto.getMobile());
			
			customer = modelMapper.map(customerEntity, CustomerDto.class);
			
			for(int i = 0; i< customer.getOrders().size(); i++) {
				OrderDto orderDto = customer.getOrders().get(i);
				orderDto.setOrderOwnerMobile(customer.getMobile());
				orderDto.setOrderOwnerFirstName(customer.getFirstName());
				
				OrderResModel order = modelMapper.map(orderDto, OrderResModel.class);
				returnValues.add(order);
				
			}
			
			return returnValues;
		}else {
			return null;
		}
		
	}
	
	@Override
	public List<CustomerResModel> getAllCutomer() {
		List<CustomerResModel> customerRes = new ArrayList<CustomerResModel>();
		List<CustomerEntity> customers = customerRepository.findAll();
		
		ModelMapper modelMapper = new ModelMapper();
		
		if(customers != null) {
			for(CustomerEntity c : customers) {
				CustomerDto customerDto = modelMapper.map(c, CustomerDto.class);
				CustomerResModel customerResModel = modelMapper.map(customerDto, CustomerResModel.class);
				customerRes.add(customerResModel);
			}
			return customerRes;
		}else {
			return null;
		}
		
		
		
	}
	@Override
	public CustomerResModel updateCustomer(CustomerDto customerDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		CustomerEntity customerEntity = customerRepository.findByPublicCustomerId(customerDto.getPublicCustomerId());
		
		if(customerEntity != null) {
			customerEntity.setFirstName(customerDto.getFirstName());
			customerEntity.setLastName(customerDto.getLastName());
			customerEntity.setEmail(customerDto.getEmail());
			customerEntity.setMobile(customerDto.getMobile());
			
			CustomerEntity updateCustomer = customerRepository.save(customerEntity);
			CustomerDto customer = modelMapper.map(updateCustomer, CustomerDto.class);
			CustomerResModel updatedRes = modelMapper.map(customer, CustomerResModel.class);
			return updatedRes;
		}else {
			return null;
		}
		
		
	}
	public CustomerDto getCustomerByMobile(CustomerDto customerDto) {
		
		CustomerEntity customerEntity = customerRepository.findByMobile(customerDto.getMobile());
		ModelMapper modelMapper = new ModelMapper();
		if(customerEntity != null) {
			CustomerDto customer = modelMapper.map(customerEntity, CustomerDto.class);
			return customer;
		}
		
		return null;
	}
}
