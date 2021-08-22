package com.li.scorpius.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.li.scorpius.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Employee.class, id);
	}

	@Override
	public void upsert(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = findById(id);
		session.delete(employee);
	}

}
