package com.educandoweb.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public List<Product>findall(){
		List<Product>list = repository.findAll();
		return list;
	}
	
	public Product findbyid(Integer id) {
		Optional<Product>product = repository.findById(id);
		return product.get();
	}
	
}
