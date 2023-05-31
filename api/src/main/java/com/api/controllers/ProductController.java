package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.api.entities.Product;
import com.api.service.ProductService;

import jakarta.servlet.Filter;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		Product product2 = productService.addProduct(product);
		return product2;
	}

	// to get all the products
	@GetMapping
	public List<Product> findAll() {
		List<Product> products = productService.findAll();
		return products;
	}

	// search product API (by name)
	@GetMapping(value = "/name/{name}")
	public List<Product> findByName(@PathVariable String name) {
		List<Product> product = productService.findByName(name);

		return product;
	}

	// search product API (by productCode)
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/code/{code}")
	public Product getByProduct(@PathVariable String code) {
		Product product = productService.getByCode(code);
		return product;
	}

	// search product API (by brand)
	@GetMapping("/brand/{brand}")
	public List<Product> findByBrand(@PathVariable String brand) {
		List<Product> product = productService.findByBrand(brand);
		return product;
	}

	// search product by description containing any given word
	@GetMapping("/description/{word}")
	public List<Product> findByDescription(@PathVariable String word) {
		List<Product> list = productService.findByDescriptionContaining(word);
		return list;

	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }

}
