package com.tharindu.tailor.service;


import java.util.List;

import com.tharindu.tailor.dto.CustomerDto;
import com.tharindu.tailor.res.model.CustomerResModel;
import com.tharindu.tailor.res.model.ItemResModel;
import com.tharindu.tailor.res.model.OrderResModel;

public interface CustomerService {
	CustomerDto createCustomer(CustomerDto customerDto);
	//CustomerUpdateResModel updateCustomer(CustomerDto customerDto);
	List<ItemResModel> getAllItems(CustomerDto customerDto);
	List<OrderResModel> getAllOrders(CustomerDto customerDto);
	List<CustomerResModel> getAllCutomer();
	CustomerResModel updateCustomer(CustomerDto customerDto);
}
