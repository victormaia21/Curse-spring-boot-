package com.educandoweb.workshop.resoucers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductResoucers {

	@Autowired
	ProductService service;
	
	@GetMapping
	ResponseEntity<List<Product>>findall() {
		List<Product>list = service.findall();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product>findbyid(@PathVariable Integer id) {
		Product product = service.findbyid(id);
		return ResponseEntity.ok().body(product);
	}
}
