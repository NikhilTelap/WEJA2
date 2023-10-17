package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeDAO {
	
private static EntityManagerFactory entityManagerFactory;
private static EntityManager entityManager;
private static EntityTransaction entityTransaction;

private static void openConnection() {
	entityManagerFactory=Persistence.createEntityManagerFactory("alpha");
	entityManager=entityManagerFactory.createEntityManager();
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
	
	employeeDTO.setId(1);
	employeeDTO.setName("nikhil");
	employeeDTO.setAddress("Pune");
	employeeDTO.setContact(1234567890);
	employeeDTO.setEmail("nikhil@gmail.com");
	
	entityManager.persist(employeeDTO);
	
	entityTransaction.commit();
	closeConnection();
}

}