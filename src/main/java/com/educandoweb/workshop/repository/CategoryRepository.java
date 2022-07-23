package com.educandoweb.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.workshop.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
