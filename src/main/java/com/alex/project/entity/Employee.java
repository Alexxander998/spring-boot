package com.alex.project.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String CNP;

	@Column(nullable = false)
	private String role;

	@Column(nullable = false)
	private double salary;

	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;

	@SuppressWarnings("unused")
	private Employee() {

	}

	public Employee(String name, String CNP, String role, double salary, Store store) {
		this.name = name;
		this.CNP = CNP;
		this.role = role;
		this.salary = salary;
		this.store = store;
	}

	@Override
	public String toString() {
		return "Employee: " + name + ", CNP:" + CNP + ", role:" + role + ", salary: " + salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CNP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(CNP, other.CNP);
	}

}
