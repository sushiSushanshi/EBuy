package com.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.Product;
import com.api.exceptions.ResourceNotFoundException;
import com.api.repository.ProductRepo;
import com.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product getByCode(String code) {
		Product product = productRepo.findById(code).orElseThrow(() ->new ResourceNotFoundException("Product with this code does not exist: "+code));
		return product;
	}

	@Override
	public List<Product> findByName(String name) {
		List<Product> product= productRepo.findByName(name);
		
		return product;
	}

	@Override
	public List<Product> findByBrand(String brand) {
		List<Product> product = productRepo.findByBrand(brand);
		return product;
	}

	@Override
	public List<Product> findByDescriptionContaining(String word) {
		List<Product> product = productRepo.findByDescriptionContaining(word);
		return product;
	}


	@Override
	public List<Product> findAll() {
		List<Product> product = productRepo.findAll();
		return product;
	}

	@Override
	public List<Product> findByBrand() {
		
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		Product product2 = productRepo.save(product);
		return product2;
	}	
	
	

}
