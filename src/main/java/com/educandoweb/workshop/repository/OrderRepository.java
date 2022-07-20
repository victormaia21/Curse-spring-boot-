package com.educandoweb.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.workshop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
