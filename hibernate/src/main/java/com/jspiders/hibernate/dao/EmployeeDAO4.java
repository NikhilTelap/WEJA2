package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeDAO4 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
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
		
		EmployeeDTO emp =entityManager.find(EmployeeDTO.class, 1);
		
		emp.setName("niraj");
		emp.setAddress("Punawale");
		emp.setEmail("niraj@gmail.com");
		entityManager.persist(emp);
		System.out.println(emp);
		
		entityTransaction.commit();
		closeConnection();
	}


}
