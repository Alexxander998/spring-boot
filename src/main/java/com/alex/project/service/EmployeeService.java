package com.alex.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.project.MtO.EmployeeMTO;
import com.alex.project.entity.Employee;
import com.alex.project.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<EmployeeMTO> getAllEmployees() {
		List<EmployeeMTO> employees = new ArrayList<EmployeeMTO>();
		employeeRepository.findAll()
				.forEach(employee -> employees.add(
						new EmployeeMTO(employee.getId(), employee.getName(), employee.getCNP(), employee.getRole(),
								employee.getSalary(), employee.getStore().getId(), employee.getStore().getName())));
		return employees;
	}

	public EmployeeMTO findEmployeeMTOById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return new EmployeeMTO(employee.get().getId(), employee.get().getName(), employee.get().getCNP(),
					employee.get().getRole(), employee.get().getSalary(), employee.get().getStore().getId(),
					employee.get().getStore().getName());
		} else {
			throw new RuntimeException("Cannot find employees with ID :" + id);
		}
	}

	public Employee findEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RuntimeException("Cannot find employees with ID :" + id);
		}
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void removeEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}
}
