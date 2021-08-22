package com.li.scorpius.dao;

import java.util.List;

import com.li.scorpius.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
	
	Employee findById(int id);
	
	void upsert(Employee employee);
	
	void deleteById(int id);
}


