package com.jspiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.dto.AadharCard;
import com.jspiders.onetoone.dto.Person;


public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory != null)
		{
			entityManagerFactory.close();
		}
		if(entityManager !=null) {
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
		
		Person person = new Person();
		
		person.setId(1);
		person.setEmail("nikhil@gmail.com");
		person.setName("nikhil");
		
		AadharCard aadharcard = new AadharCard();
		
		aadharcard.setId(1);
		aadharcard.setAadharNumber(123456654765L);
		aadharcard.setDateOfIssue("1/6/2000");
		

		entityManager.persist(person);
		entityManager.persist(aadharcard);

		entityTransaction.commit();
		closeConnection();
	}
}
