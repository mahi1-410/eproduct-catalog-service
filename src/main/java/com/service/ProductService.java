package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.domain.Product;
import com.entity.*;

import com.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Cacheable("products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Cacheable("products")
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@CacheEvict(value = "products", allEntries = true)
	public Product createOrUpdateProduct(Product product) {
		return productRepository.save(product);
	}

	@CacheEvict(value = "products", allEntries = true)
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
