package com.alex.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.alex.project.entity.Employee;
import com.alex.project.entity.Product;
import com.alex.project.entity.Store;
import com.alex.project.service.EmployeeService;
import com.alex.project.service.ProductService;
import com.alex.project.service.StoreService;

@Component
public class Init {

	@Autowired
	private ProductService productService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private StoreService storeService;

	@Bean
	@Profile("default")
	public void initData() {
		Store store1 = new Store("eMAG", "str. Piata Consiliul Europei, nr. 2");
		Store store2 = new Store("eMAG", "str. B-dul Liviu Rebreanu, nr. 2-5");
		Store store3 = new Store("Altex", "str. Calea Aradului, nr. 58A");
		storeService.addStore(store1);
		storeService.addStore(store2);
		storeService.addStore(store3);

		productService.addProduct(new Product("Samsung Galaxy S22", 4000, 50));
		productService.addProduct(new Product("tv samsung", 2500, 25));
		productService.addProduct(new Product("casti razer", 500, 7));
		productService.addProduct(new Product("Galaxy Watch 5 PRO", 2500, 2));

		employeeService.addEmployee(new Employee("Xulescu", "123", "sef raion", 2000, store1));
		employeeService.addEmployee(new Employee("Popescu", "234", "casier", 1700, store1));
		employeeService.addEmployee(new Employee("Ionescu", "345", "casier", 1600, store2));
		employeeService.addEmployee(new Employee("Marinescu", "456", "sofer", 2000, store1));
		
	}

}
