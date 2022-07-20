package com.educandoweb.workshop.resoucers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResoucers {
	
	@Autowired
	UserService service;
	
	@GetMapping
	ResponseEntity<List<User>>findall() {
		List<User>list = service.findall();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User>findbyid(@PathVariable Integer id){
		User user = service.findbyid(id);
		return ResponseEntity.ok().body(user);
	}
	
	
	

	

}
