package com.li.scorpius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.scorpius.dao.EmployeeDAO;
import com.li.scorpius.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	public void upsert(Employee employee) {
		employeeDAO.upsert(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}
}
