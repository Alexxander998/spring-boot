package com.alex.project.MtO;

public class EmployeeMTO {

	private Long id;

	private String name;

	private String CNP;

	private String role;

	private double salary;

	private Long storeId;

	private String storeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public EmployeeMTO(Long id, String name, String CNP, String role, double salary, Long storeId, String storeName) {
		this.id = id;
		this.name = name;
		this.CNP = CNP;
		this.role = role;
		this.salary = salary;
		this.storeId = storeId;
		this.storeName = storeName;
	}

}
