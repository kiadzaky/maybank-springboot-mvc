package com.maybank.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.todo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
 
}