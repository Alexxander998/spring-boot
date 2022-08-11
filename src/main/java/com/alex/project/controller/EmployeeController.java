package com.alex.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.project.MtO.EmployeeMTO;
import com.alex.project.entity.Employee;
import com.alex.project.service.EmployeeService;
import com.alex.project.service.StoreService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private StoreService storeService;

	@PostMapping(path = "/employee/{name}/{cnp}/{role}/{salary}/{storeID}")
	public void addEmployee(@PathVariable String name, @PathVariable String CNP, @PathVariable String role,
			@PathVariable double salary, @PathVariable Long storeID) {
		employeeService.addEmployee(new Employee(name, CNP, role, salary, storeService.findStoreById(storeID)));
	}

	@GetMapping(path = "/employees")
	public List<EmployeeMTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(path = "/employees/{id}")
	public EmployeeMTO getEmployeeById(@PathVariable Long id) {
		return employeeService.findEmployeeMTOById(id);
	}

	@PutMapping(path = "/employee/{id}/{name}/{cnp}/{role}/{salary}/{store}")
	public void updateEmployee(@PathVariable Long id, @PathVariable String name, @PathVariable String CNP,
			@PathVariable String role, @PathVariable double salary, @PathVariable Long store) {
		Employee employee = employeeService.findEmployeeById(id);
		employee.setName(name);
		employee.setCNP(CNP);
		employee.setRole(role);
		employee.setSalary(salary);
		employee.setStore(storeService.findStoreById(store));
		employeeService.updateEmployee(employee);
	}

	@DeleteMapping(path = "employees/d/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.removeEmployeeById(id);
	}
}
