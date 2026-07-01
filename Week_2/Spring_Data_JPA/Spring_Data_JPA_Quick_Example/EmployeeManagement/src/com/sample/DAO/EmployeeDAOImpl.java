package com.sample.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sample.Models.Employee;

import jakarta.transaction.Transactional;
@Repository
@Transactional

public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void Save(Employee emp) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(emp);
	  System.out.println("Employee Datails Saved Successfully");
		
	}

	@Override
	public void Update(Employee emp) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.merge(emp);
	  System.out.println("Employee Datails Updated Successfully");
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Employee emp=session.get(Employee.class,id);
		if(emp!=null)
		{
			session.remove(emp);
			System.out.println("Employee Data Delete Successfully");
		}else {
			System.out.println("No Data With Given Id!");
		}
	}

	@Override
	public List<Employee> GetAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Employee",Employee.class).list();
	}

}