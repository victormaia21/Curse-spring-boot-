package com.educandoweb.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;
	
	public List<Category>findall(){
       List<Category>list = repository.findAll();
       return list;
	}
	
	public Category findbyid(Integer id) {
		Optional<Category>category = repository.findById(id);
		return category.get();
	}
}
