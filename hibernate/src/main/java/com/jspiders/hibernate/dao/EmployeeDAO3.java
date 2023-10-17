package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeDAO3 {
	
	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
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
		
		EmployeeDTO emp = entityManager.find(EmployeeDTO.class, 1);
		
		System.out.println(emp);
		closeConnection();
	}

}
