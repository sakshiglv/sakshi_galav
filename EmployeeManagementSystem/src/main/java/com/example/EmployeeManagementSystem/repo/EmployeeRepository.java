package com.example.EmployeeManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
