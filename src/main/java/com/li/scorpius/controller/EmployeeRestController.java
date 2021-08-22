package com.li.scorpius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.li.scorpius.entity.Employee;
import com.li.scorpius.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		return employeeService.findById(employeeId);
	}

	@PostMapping("/employees")
	public Employee upsert(@RequestBody Employee employee) {
		employeeService.upsert(employee);
		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteById(@PathVariable(name="employeeId") int id) {
		employeeService.deleteById(id);
		return "id deleted";
		
	}
}
