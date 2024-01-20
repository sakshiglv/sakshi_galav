package com.example.EmployeeManagementSystem.service;

import java.util.List;

import com.example.EmployeeManagementSystem.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee employee);
	void deleteEmployeeById(Long id);


}
