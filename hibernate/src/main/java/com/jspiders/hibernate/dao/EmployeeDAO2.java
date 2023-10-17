package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	private static void closeConnection() {
		if(entityManagerFactory !=null) {
			entityManagerFactory.close();
		}
		if(entityManager !=null) {
			entityManager.close();
		}
		if(entityTransaction !=null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(2);
		employeeDTO.setName("vivek");
		employeeDTO.setAddress("nigdi");
		employeeDTO.setEmail("vivek@gmail.com");
		employeeDTO.setContact(9876544321L);
		
		entityManager.persist(employeeDTO);
		
		EmployeeDTO employeeDTO2 = new EmployeeDTO();
		employeeDTO2.setId(3);
		employeeDTO2.setName("adnan");
		employeeDTO2.setAddress("dehu");
		employeeDTO2.setEmail("dehu@gmail.com");
		employeeDTO2.setContact(9216544321L);
		
		entityManager.persist(employeeDTO2);
		entityTransaction.commit();
		closeConnection();
		
	}

}
