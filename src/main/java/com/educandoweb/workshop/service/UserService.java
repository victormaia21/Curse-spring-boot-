package com.educandoweb.workshop.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repository.UserRepository;
import com.educandoweb.workshop.service.exception.DataBaseException;
import com.educandoweb.workshop.service.exception.ResourceNotFoundException;

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
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		user = repository.save(user);
		return user;
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Integer id, User obj) {
		try {
			Optional<User>entity = repository.findById(id);
			updatedata(entity,obj);
			return entity.get();
			} 
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updatedata(Optional<User> entity, User obj) {
		entity.get().setEmail(obj.getEmail());
		entity.get().setName(obj.getName());
		entity.get().setPhone(obj.getPhone());
		
	}

	
}
