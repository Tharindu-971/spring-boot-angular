package com.tharindu.tailor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tharindu.tailor.dao.CustomerRepository;
import com.tharindu.tailor.dao.OrderRepository;
import com.tharindu.tailor.dto.CustomerDto;
import com.tharindu.tailor.dto.ItemDto;
import com.tharindu.tailor.dto.OrderDto;
import com.tharindu.tailor.entity.CustomerEntity;
import com.tharindu.tailor.entity.OrderEntity;
import com.tharindu.tailor.res.model.OrderResModel;
import com.tharindu.tailor.service.OrderService;
import com.tharindu.tailor.shared.Utils;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	private Utils publicId;

	@Override
	public OrderDto createNewOrderToExistingCustomer1(OrderDto orderDto) {
		
		OrderDto returnValue = new OrderDto();		
		ModelMapper modelMapper = new ModelMapper();
		
		if(customerRepository.findByMobile(orderDto.getOrderOwnerMobile()) != null) {
			OrderDto order = orderDto;
			CustomerEntity customer = customerRepository.findByMobile(orderDto.getOrderOwnerMobile());
			CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
			
			order.setPublicOrderId(publicId.publicId(30));
			order.setCustomer(customerDto);
			
			
			for(int i = 0; i < order.getItems().size(); i++) {
				ItemDto items = order.getItems().get(i);
				items.setPublicItemId(publicId.publicId(30));
				items.setOwner(order.getItems().get(i).getOwner());
				items.setOrder(order);
				
				order.getItems().set(i, items);
			}
			
			OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);		
			OrderEntity savedOrder =  orderRepository.save(orderEntity);
			
			returnValue = modelMapper.map(savedOrder, OrderDto.class);
			
			returnValue.setOrderOwnerFirstName(customerDto.getFirstName());
			returnValue.setOrderOwnerMobile(customerDto.getMobile());
			
			return returnValue;
		}else {
			return null;
		}
		
	}

	public OrderResModel updateOrder(OrderDto orderDto) {
		
		OrderEntity order = orderRepository.findByPublicOrderId(orderDto.getPublicOrderId());
		
		OrderDto newOrderDto = new OrderDto();
		
		OrderResModel returnValue = new OrderResModel();
		
		if(order != null) {
			CustomerEntity customer = customerRepository.findById(order.getCustomer().getId()).get();
			order.setDeliveryDate(orderDto.getDeliveryDate());
			order.setAdvance(orderDto.getAdvance());
			order.setType(orderDto.getType());
			order.setOrderStatus(orderDto.getOrderStatus());
			order.setTotal(orderDto.getTotal());
			OrderEntity savedOrder = orderRepository.save(order);
			
			BeanUtils.copyProperties(savedOrder, newOrderDto);
			newOrderDto.setOrderOwnerFirstName(customer.getFirstName());
			newOrderDto.setOrderOwnerMobile(customer.getMobile());
			
			BeanUtils.copyProperties(newOrderDto, returnValue);
			
			
			return returnValue;
		}else {
			return null;
		}
		
	}

	public List<OrderResModel> getAllOrders() {
		
		List<OrderResModel> ordersRes = new ArrayList<OrderResModel>();
		ModelMapper modelMapper = new ModelMapper();
		List<OrderEntity>  orders = orderRepository.findAll();
		
		if(orders.size() != 0) {
			for(int i = 0; i < orders.size(); i++) {
				OrderDto orderDto = modelMapper.map(orders.get(i), OrderDto.class);
				orderDto.setOrderOwnerFirstName(orders.get(i).getCustomer().getFirstName());
				orderDto.setOrderOwnerMobile(orders.get(i).getCustomer().getMobile());
				OrderResModel orderRes = modelMapper.map(orderDto, OrderResModel.class);
				ordersRes.add(orderRes);	
			}
			
			return ordersRes;
		}else {
			return null;
		}

	}

	public OrderResModel getAllOrder(String publicId) {
		
		OrderDto orderDto = new OrderDto();
		orderDto.setPublicOrderId(publicId);
		OrderEntity order = orderRepository.findByPublicOrderId(orderDto.getPublicOrderId());
		//CustomerEntity customer = customerRepository.findById(order.getCustomer().getId()).get();
		ModelMapper modelMapper = new ModelMapper();
		if(order != null) {
			
			orderDto = modelMapper.map(order, OrderDto.class);
			orderDto.setOrderOwnerFirstName(orderDto.getCustomer().getFirstName());
			orderDto.setOrderOwnerMobile(orderDto.getCustomer().getMobile());
			OrderResModel orderRes = modelMapper.map(orderDto, OrderResModel.class);
			
			return orderRes;
		}
		
		return null;
	}
	
	

}














