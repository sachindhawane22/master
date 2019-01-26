package com.sachin.spring.autowiring.service;

import com.sachin.spring.autowiring.model.Employee;

public class EmployeeService {
	private Employee employee3;

	// constructor is used for autowiring by constructor
	public EmployeeService(Employee emp) {
		System.out.println("Autowiring by constructor used");
		this.employee3 = emp;
	}

	// default constructor to avoid BeanInstantiationException for autowiring
	// byName or byType
	public EmployeeService() {
		System.out.println("Default Constructor used");
	}

	// used for autowire byName and byType
	public void setEmployee(Employee emp) {
		this.employee3 = emp;
	}

	public Employee getEmployee() {
		return this.employee3;
	}

}
