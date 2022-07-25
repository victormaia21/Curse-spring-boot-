package com.educandoweb.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repository.UserRepository;
import com.educandoweb.workshop.service.exception.DatabaseException;
import com.educandoweb.workshop.service.exception.ResourcesNotFoundException;

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
		return user.orElseThrow(() -> new ResourcesNotFoundException(id));
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
        	throw new ResourcesNotFoundException(id);
        }
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
        
	}
	
	public User update(Integer id, User obj) {
		Optional<User>entity = repository.findById(id);
		updatedata(entity,obj);
		return entity.get();
	}

	private void updatedata(Optional<User> entity, User obj) {
		entity.get().setEmail(obj.getEmail());
		entity.get().setName(obj.getName());
		entity.get().setPhone(obj.getPhone());
		
	}

	
}
