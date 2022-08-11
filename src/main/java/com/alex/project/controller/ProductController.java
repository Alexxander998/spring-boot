package com.alex.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.project.entity.Product;
import com.alex.project.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/product/{name}/{price}/{quantity}")
	public void createProduct(@PathVariable String name, @PathVariable double price, @PathVariable int quantity) {
		productService.addProduct(new Product(name, price, quantity));
	}

	@GetMapping(path = "/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(path = "/products/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}

	@PutMapping(path = "/product/{id}/{name}/{price}/{quantity}")
	public void updateProduct(@PathVariable Long id, @PathVariable String name, @PathVariable double price,
			@PathVariable int quantity) {
		Product product = productService.findProductById(id);
		product.setName(name);
		product.setPrice(price);
		product.setQuantity(quantity);
		productService.updateProduct(product);
	}

	@DeleteMapping(path = "products/d/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.removeProductById(id);
	}

}
