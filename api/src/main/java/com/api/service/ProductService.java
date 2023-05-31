package com.api.service;

import java.util.List;

import com.api.entities.Product;

public interface ProductService {
	List<Product> findAll();
	Product getByCode(String name);
	List<Product> findByName(String name);
	List<Product> findByBrand(String brand);
	List<Product> findByBrand();
	List<Product> findByDescriptionContaining(String word);
	Product addProduct(Product product);
}
