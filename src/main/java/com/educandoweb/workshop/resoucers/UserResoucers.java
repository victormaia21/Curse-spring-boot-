package com.educandoweb.workshop.resoucers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResoucers {
	
	@GetMapping
	ResponseEntity<User>findall() {
		User u = new User(1, "fqwwq", "dqwdq", "wqdqwd", "fwdqwd");
		return ResponseEntity.ok().body(u);
	}
	

	

}
