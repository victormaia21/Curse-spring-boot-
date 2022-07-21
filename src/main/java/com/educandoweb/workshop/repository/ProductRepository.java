package com.educandoweb.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.workshop.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
