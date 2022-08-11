package com.alex.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alex.project.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
