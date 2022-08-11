package com.alex.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.project.entity.Product;
import com.alex.project.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> products.add(product));
		return products;
	}

	public Product findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			return product.get();
		} else {
			throw new RuntimeException("Cannot find product with ID :" + id);
		}
	}

	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	public void removeProductById(Long id) {
		productRepository.deleteById(id);
	}
}
