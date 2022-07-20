package com.educandoweb.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.workshop.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
}
