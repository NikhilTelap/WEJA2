package com.jspiders.manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.Course;
import com.jspiders.manytomany.dto.Student;

public class StudentDao {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory != null){
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
		
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("ram");
		student1.setEmail("ram@gmail.com");
		student1.setAddress("Pune");
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("laxman");
		student2.setEmail("laxman@gmail.com");
		student2.setAddress("mumbai");
		
		Course course1 = new Course();
		course1.setId(1);
		course1.setName("SQL");
		course1.setFees(5000L);
		
		Course course2 = new Course();
		course2.setId(2);
		course2.setName("Core-java");
		course2.setFees(6000L);
		
		
		
		List<Course> courses1 = new ArrayList<Course>();
					courses1.add(course2);
	
		List<Course> courses2 = new ArrayList<Course>();
					courses2.add(course2);
					courses2.add(course1);
					
					entityManager.persist(student1);
					entityManager.persist(student2);

					entityManager.persist(course1);

					entityManager.persist(course2);


					
		
		entityTransaction.commit();
		closeConnection();
	}

}
