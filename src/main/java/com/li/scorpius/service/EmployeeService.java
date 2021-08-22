package com.li.scorpius.service;

import java.util.List;

import com.li.scorpius.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int id);
	
	void upsert(Employee employee);
	
	void deleteById(int id);
}
