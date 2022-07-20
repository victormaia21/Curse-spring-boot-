package com.educandoweb.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	
	public List<Order>findall() {
		List<Order>list = repository.findAll();
		return list;
	}
	
	public Order findbyid(Integer id) {
		Optional<Order>user = repository.findById(id);
		return user.get();
	}
	
}
