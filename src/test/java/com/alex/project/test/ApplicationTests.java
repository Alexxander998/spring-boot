package com.alex.project.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alex.project.controller.EmployeeController;
import com.alex.project.entity.Employee;
import com.alex.project.entity.Store;
import com.alex.project.service.EmployeeService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private EmployeeController controller;

	@Test
	void addEmployee() {
		controller.addEmployee("nume", "123", "rol", 100, 1L);
		assertEquals(controller.getAllEmployees().get(controller.getAllEmployees().size() - 1).getName(), "nume");
	}
	
	@Test
	void updateEmployee() {
		//controller.updateEmployee(8L, "name", null, null, 0, null);
	}

}
