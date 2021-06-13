package com.tharindu.tailor.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tharindu.tailor.dto.OrderDto;
import com.tharindu.tailor.req.order.AddNewOrdetToCustomerReqModel;
import com.tharindu.tailor.req.order.UpdateOrderReqModel;
import com.tharindu.tailor.res.model.OrderResModel;
import com.tharindu.tailor.service.impl.OrderServiceImpl;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImple;

	@PostMapping("/order")
	public ResponseEntity<Object> addNewOrder(@RequestBody AddNewOrdetToCustomerReqModel newOrder) {
		ModelMapper modelMapper = new ModelMapper();
		OrderDto orderDto = modelMapper.map(newOrder, OrderDto.class);
		OrderDto newOrderDto = orderServiceImple.createNewOrderToExistingCustomer1(orderDto);

		OrderResModel orderRes = modelMapper.map(newOrderDto, OrderResModel.class);

		HttpHeaders headers = new HttpHeaders();
		if (orderRes != null) {

			headers.add("Responded", "Create New Order");
			return ResponseEntity.accepted().body(orderRes);
		} else {
			headers.add("Responded", "customer dose not exist");
			return ResponseEntity.unprocessableEntity().body("customer dose not exist");
		}
	}
	
	@PutMapping("/order")
	public ResponseEntity<Object> updateOrder(@RequestBody UpdateOrderReqModel updateOrder){
		
		OrderDto orderDto = new OrderDto();
		BeanUtils.copyProperties(updateOrder, orderDto);
		OrderResModel orderRes = orderServiceImple.updateOrder(orderDto);
		
		HttpHeaders headers = new HttpHeaders();
		if (orderRes != null) {

			headers.add("Responded", "update Order");
			return ResponseEntity.accepted().body(orderRes);
		} else {
			headers.add("Responded", "order dose not exist");
			return ResponseEntity.unprocessableEntity().body("order dose not exist");
		}
	}
	
	@GetMapping("/order")
	public ResponseEntity<Object> getAllOrders(){
		List<OrderResModel> orders = orderServiceImple.getAllOrders();
		
		HttpHeaders headers = new HttpHeaders();
		if (orders != null) {

			headers.add("Responded", "list of all orders");
			return ResponseEntity.accepted().body(orders);
		} else {
			headers.add("Responded", "orders empty");
			return ResponseEntity.unprocessableEntity().body("orders empty");
		}
	}
	
	@GetMapping("/order/{publicId}")
	public ResponseEntity<Object> getAllOrder(@PathVariable String publicId){
		OrderResModel order = orderServiceImple.getAllOrder(publicId);
		
		HttpHeaders headers = new HttpHeaders();
		if (order != null) {

			headers.add("Responded", "order with public id");
			return ResponseEntity.accepted().body(order);
		} else {
			headers.add("Responded", "orders empty");
			return ResponseEntity.unprocessableEntity().body("order does not exist");
		}
	}

}