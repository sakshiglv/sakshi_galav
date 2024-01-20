package com.example.EmployeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employee",employeeService.getAllEmployee());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "employees";
	}
    
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";}
		
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id,  Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "edit_employee";}
	
		
	@PostMapping("/employees/{id}")
	public String updateEmployeeForm(@PathVariable Long id, @ModelAttribute("employee")Employee updatedEmployee , Model model) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirst_name(updatedEmployee.getFirst_name());
		existingEmployee.setLast_name(updatedEmployee.getLast_name());
		existingEmployee.setEmail(updatedEmployee.getEmail());
		
		employeeService.updateEmployee(existingEmployee);
		return "edit_employee";}
		
		@GetMapping("/employees/{id}")
		public String deleteEmployee(@PathVariable Long id) {
			employeeService.deleteEmployeeById(id);
			return "redirect:/employees";	
}
}