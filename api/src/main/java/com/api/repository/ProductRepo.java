package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entities.Product;


public interface ProductRepo extends JpaRepository<Product, String>{
	List<Product> findByName(String name);
	List<Product> findByBrand(String brand);
	List<Product> findByDescriptionContaining(String word);
	
}
