package com.example.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.service.OrderService;
import com.example.order.vo.OrderVo;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("/orderbyid/{orderId}")
	public ResponseEntity<Object> getOrderById(@PathVariable Long orderId){
		return new ResponseEntity<Object>(service.getOrderById(orderId), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveOrder(@Valid @RequestBody OrderVo order){
		return new ResponseEntity<Object>(service.saveOrder(order),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<Object> deleteOrder(@PathVariable Long orderId){
		return new ResponseEntity<Object>(service.deleteOrder(orderId),HttpStatus.OK);
	}
}
