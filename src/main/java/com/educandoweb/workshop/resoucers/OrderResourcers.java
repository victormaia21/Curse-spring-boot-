package com.educandoweb.workshop.resoucers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResourcers {

	@Autowired
	OrderService service;
	
	@GetMapping
	public List<Order>findall() {
		List<Order>list = service.findall();
		return list;
	}
	
	@GetMapping(value = "{id}")
	public Order findbyid(@PathVariable Integer id) {
		Order order = service.findbyid(id);
		return order;
	}
}
