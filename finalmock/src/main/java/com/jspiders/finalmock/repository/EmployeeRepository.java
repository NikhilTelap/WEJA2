package com.jspiders.finalmock.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jspiders.finalmock.pojo.EmployeePOJO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Repository
public class EmployeeRepository {
		
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("finalmock");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		
		if(transaction != null)
		{
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	
	public EmployeePOJO addEmployee(String name) {

		openConnection();
		transaction.begin();
		
		EmployeePOJO employee = new EmployeePOJO();
		employee.setName(name);
		
		manager.persist(employee);
		transaction.commit();
		closeConnection();
		
		return employee;
	}

	public List<EmployeePOJO> findAllEmployees() {

		openConnection();
		transaction.begin();
		
		String jpql = "from EmployeePOJO";
		query = manager.createQuery(jpql);
		  List<EmployeePOJO> employees = query.getResultList();
	        if (employees.isEmpty()==false) {
	        	transaction.commit();
	    		closeConnection();
	    		return employees;
			}	
		transaction.commit();
		closeConnection();
		return null;
	}

	public List<EmployeePOJO> searchPattern(String pattern) {
		openConnection();
		transaction.begin();
		
	 
		String jpql = "from EmployeePOJO";
		
		query = manager.createQuery(jpql);
		  List<EmployeePOJO> employees = query.getResultList();
		  
		  ArrayList<EmployeePOJO> employees2 = new ArrayList<EmployeePOJO>();
	
		  for(int i=0;i<employees.size();i++) {
			EmployeePOJO name = employees.get(i);
			if(name.getName().contains(pattern)) {
				employees2.add(employees.get(i));
				
			}
		  }
		 
	        if (employees2.isEmpty()==false) {
	        	transaction.commit(); 
	    		closeConnection();
	    		return employees2;
			}	
		transaction.commit();
		closeConnection();
		
		return null;
	}

	
}
