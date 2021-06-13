package com.tharindu.tailor.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tharindu.tailor.dto.CustomerDto;
import com.tharindu.tailor.req.customer.CreateCustomerReqModel;
import com.tharindu.tailor.req.customer.UpdateCustomerReqModel;
import com.tharindu.tailor.res.model.CustomerResModel;
import com.tharindu.tailor.res.model.ItemResModel;
import com.tharindu.tailor.res.model.OrderResModel;
import com.tharindu.tailor.service.impl.CustomerServiceImpl;


@RestController

public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	
	@PostMapping("/customer")
	public ResponseEntity<Object> addUser(@RequestBody CreateCustomerReqModel customer) {

		ModelMapper modelMapper = new ModelMapper();
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		
		CustomerDto createCustomer = customerService.createCustomer(customerDto);
		
		CustomerResModel returnValue = modelMapper.map(createCustomer, CustomerResModel.class);
		
		
		
		HttpHeaders headers = new HttpHeaders();
		if(returnValue != null) {
			
			headers.add("Responded", "Create New Customer");
			
			return ResponseEntity.accepted().body(returnValue);
		}else {
			headers.add("Responded", "customer already exist");
			return ResponseEntity.unprocessableEntity().body("customer already exist");		
			}
		
	}
	
	@GetMapping("/customer/items/{mobile}")
	public ResponseEntity<Object> getAllItems(@PathVariable String mobile){
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setMobile(mobile);
		
		List<ItemResModel> items = customerService.getAllItems(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		
		if(items != null) {
			headers.add("Responded", "All items associate with this customer");
			
			return ResponseEntity.accepted().body(items);
		}else {
			headers.add("Responded", "customer does not exist");
			return ResponseEntity.unprocessableEntity().body("customer does not exist");	
		}
		
		
	}
	@GetMapping("/customer/order/{mobile}")
	public ResponseEntity<Object> getAllOrders(@PathVariable String mobile){
		CustomerDto customerDto = new CustomerDto();
		customerDto.setMobile(mobile);
		
		List<OrderResModel> orders = customerService.getAllOrders(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		
		if(orders != null) {
			headers.add("Responded", "All items associate with this customer");
			
			return ResponseEntity.accepted().body(orders);
		}else {
			headers.add("Responded", "customer does not exist");
			return ResponseEntity.unprocessableEntity().body("customer does not exist");	
		}
	}
	
	@GetMapping("/customer")
	public ResponseEntity<Object> getAllCustomers(){
		List<CustomerResModel> customers = customerService.getAllCutomer();
		
		HttpHeaders headers = new HttpHeaders();
		
		if(customers != null) {
			headers.add("Responded", "All customers");
			
			return ResponseEntity.accepted().body(customers);
		}else {
			headers.add("Responded", "empty customer");
			return ResponseEntity.unprocessableEntity().body("customer empty");	
		}
	}
	
	@GetMapping("/customer/{mobile}")
	public ResponseEntity<Object> getCustomer(@PathVariable String mobile){
		
		CustomerDto customerDto = new CustomerDto();
		ModelMapper modelMapper = new ModelMapper();
		customerDto.setMobile(mobile);
		
		CustomerDto customer = customerService.getCustomerByMobile(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		
		if(customer != null) {
			CustomerResModel customerRes = modelMapper.map(customer, CustomerResModel.class);
			headers.add("Responded", " customer");
			
			return ResponseEntity.accepted().body(customerRes);
		}else {
			headers.add("Responded", "customer not found");
			return ResponseEntity.unprocessableEntity().body("customer not found");	
		}
		
	} 
	
	@PutMapping("/customer")
	public ResponseEntity<Object> updateCustomer(@RequestBody UpdateCustomerReqModel customerUpdate){
		
		CustomerDto customer = new CustomerDto();
		
		customer.setPublicCustomerId(customerUpdate.getPublicCustomerId());
		customer.setFirstName(customerUpdate.getFirstName());
		customer.setLastName(customerUpdate.getLastName());
		customer.setEmail(customerUpdate.getEmail());
		customer.setMobile(customerUpdate.getMobile());
		
		CustomerResModel updatedCustomer = customerService.updateCustomer(customer);

		HttpHeaders headers = new HttpHeaders();
		
		if(updatedCustomer != null) {
			headers.add("Responded", "All customers");
			
			return ResponseEntity.accepted().body(updatedCustomer);
		}else {
			headers.add("Responded", "customer not found");
			return ResponseEntity.unprocessableEntity().body("customer not found");	
		}
	}
}
