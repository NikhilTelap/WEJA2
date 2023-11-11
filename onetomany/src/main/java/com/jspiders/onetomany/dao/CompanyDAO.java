package com.jspiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.Company;
import com.jspiders.onetomany.dto.Employee;

public class CompanyDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		}

	private static void closeConnection() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
			
		}
		if(entityManager != null) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Company company = new Company();
		company.setId(1);
		company.setName("TCS");
		company.setEmail("tcs@gmail.com");
		
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("arjun");
		employee1.setEmail("arjun@gmail.com");
		employee1.setSalary(234565L);
		
		
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("karna");
		employee2.setEmail("karna@gmail.com");
		employee2.setSalary(234324L);
		
		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setName("bheem");
		employee3.setEmail("bheem@gmail.com");
		employee3.setSalary(2343234L);

		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		company.setEmployees(employees);
		
		entityManager.persist(employee1);
		entityManager.persist(employee2);

		entityManager.persist(employee3);
		entityManager.persist(company);
		
		
		entityTransaction.commit();
		closeConnection();
		
	}

}

