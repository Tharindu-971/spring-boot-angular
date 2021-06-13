package com.tharindu.tailor.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tharindu.tailor.dto.ItemDto;
import com.tharindu.tailor.req.item.AddNewItemToExistingOrderReqModel;
import com.tharindu.tailor.req.item.UpdateItemReqModel;
import com.tharindu.tailor.res.model.ItemResModel;
import com.tharindu.tailor.service.impl.ItemServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemServiceImpl itemServiceImpl;
	/*
	@PutMapping("/item")
	public ResponseEntity<Object> addEmployeeToItem(@RequestBody  UpdateItemReqModel addEmployeeToItem) {
		
		ItemDto itemDto = itemServiceImpl.addEmployeeToItem(addEmployeeToItem);
		
		ModelMapper modelMapper = new ModelMapper();
		HttpHeaders headers = new HttpHeaders();
		if(itemDto != null) {
			AddEmployeeToItemResModel returnValue  =  modelMapper.map(itemDto,AddEmployeeToItemResModel.class);
			returnValue.setPublicEmpId(itemDto.getEmployeeDto().getPublicEmpId());

			headers.add("Responded", "Add employee to item to sew");
			return ResponseEntity.accepted().body(returnValue);
		}else {
			headers.add("Responded", "Employee or item does not exist");
			return ResponseEntity.accepted().body(null);
		}
	}
	*/
	@PostMapping("/item")
	public ResponseEntity<Object> addNewItemToOrder(@RequestBody List<AddNewItemToExistingOrderReqModel> newItems){
		
		List<ItemResModel> returnValue = new ArrayList<ItemResModel>();
		List<ItemDto> itemsDto = new ArrayList<ItemDto>();
 		ModelMapper modelMapper = new ModelMapper();
 		ItemDto itemDto = new ItemDto();
		for(AddNewItemToExistingOrderReqModel item : newItems) {
			itemDto.setPublicOrderId(item.getPublicOrderId());
			itemDto.setQuantity(item.getQuantity());
			itemDto.setSewDate(item.getSewDate());
			itemDto.setFitonDate(item.getFitonDate());
			itemDto.setOwner(item.getOwner());
			itemDto.setStatus(item.getStatus());
			itemsDto.add(itemDto);
		}

		List<ItemDto>  items = itemServiceImpl.addNewItemsToOrder(itemsDto);
		HttpHeaders headers = new HttpHeaders();
		if(items != null) {
			for(ItemDto item : items) {
				ItemResModel itemModel = modelMapper.map(item, ItemResModel.class);
				returnValue.add(itemModel);
			}
			
			headers.add("Responded", "Create new items with Existing Order");
			
			return ResponseEntity.accepted().body(returnValue);
		}else {
			headers.add("Responded", "Employee or item does not exist");
			return ResponseEntity.accepted().body("Item not created");
		}

	}
	
	@PutMapping("/item")
	public ResponseEntity<Object> updateItem(@RequestBody UpdateItemReqModel updateItem){
		
		ModelMapper modelMapper = new ModelMapper();
		
		ItemDto itemDto = modelMapper.map(updateItem, ItemDto.class);
		
		ItemDto updated = itemServiceImpl.updateItem(itemDto);
		
		HttpHeaders headers = new HttpHeaders();
		
		if(updated != null) {
			headers.add("Responded", "employee update");
			
			return ResponseEntity.accepted().body(updated);
		}else {
			headers.add("Responded", "employee not found");
			return ResponseEntity.unprocessableEntity().body("employee not found");	
		}

	}
	@GetMapping("/item")
	public ResponseEntity<Object> getAllItems(){
		List<ItemResModel> itemRes = new ArrayList<ItemResModel>();
		List<ItemDto> itemsDto = itemServiceImpl.getAllItems();
		ModelMapper modelMapper = new ModelMapper();
		HttpHeaders headers = new HttpHeaders();
		
		if(itemsDto != null) {
			for(ItemDto item : itemsDto) {
				ItemResModel items = modelMapper.map(item, ItemResModel.class);
//				items.setAssociateCustomerFirstName(item.getAssociateCustomerFirstName());
//				items.setAssociateCustomerMobile(item.getAssociateCustomerMobile());
//				items.setAssociatedEmpName(item.getAssociatedEmpName());
				itemRes.add(items);
			}
			
			return ResponseEntity.accepted().body(itemRes);
		}else {
			headers.add("Responded", "items not found");
			return ResponseEntity.unprocessableEntity().body("items not found");	
		}
		
		
		
	}
//	@GetMapping("/item")
//	public ResponseEntity<Object> getAllItemWithStatus(){
//		List<ItemResModel> itemRes = new ArrayList<ItemResModel>();
//		List<ItemDto> itemsDto = itemServiceImpl.getAllItems();
//		ModelMapper modelMapper = new ModelMapper();
//		HttpHeaders headers = new HttpHeaders();
//		
//		if(itemsDto != null) {
//			for(ItemDto item : itemsDto) {
//				itemRes.add(modelMapper.map(item, ItemResModel.class));
//			}
//			
//			return ResponseEntity.accepted().body(itemRes);
//		}else {
//			headers.add("Responded", "items not found");
//			return ResponseEntity.unprocessableEntity().body("items not found");	
//		}
//		
//		
//		
//	}
}
