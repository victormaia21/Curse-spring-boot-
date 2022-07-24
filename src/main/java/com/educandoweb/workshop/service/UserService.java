package com.educandoweb.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
	UserRepository repository;
	
	public List<User>findall() {
		List<User>list = repository.findAll();
		return list;
	}
	
	public User findbyid(Integer id) {
		Optional<User>user = repository.findById(id);
		return user.get();
	}
	
	public User insert(User obj) {
		User user = repository.save(obj);
		return user;
	}
}
