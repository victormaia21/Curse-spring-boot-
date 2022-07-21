package com.educandoweb.workshop.resoucers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResoucers {

	@Autowired
	CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>>findall(){
		List<Category>findall = service.findall();
		return ResponseEntity.ok().body(findall);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category>findbyid(@PathVariable Integer id){
		Category category = service.findbyid(id);
		return ResponseEntity.ok().body(category);
	}
}
