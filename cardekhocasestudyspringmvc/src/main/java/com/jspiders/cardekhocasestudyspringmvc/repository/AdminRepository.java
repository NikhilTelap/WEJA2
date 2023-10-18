package com.jspiders.cardekhocasestudyspringmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhocasestudyspringmvc.pojo.AdminPOJO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Repository
public class AdminRepository {
		
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("cdcs");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction != null) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	public AdminPOJO createAccount(String username, String password) {
		
		openConnection();
		transaction.begin();
		
		AdminPOJO admin = new AdminPOJO();
		admin.setUsername(username);
		admin.setPassword(password);
		
		manager.persist(admin);
		
		transaction.commit();
		closeConnection();
		
		return admin;
	}

	public AdminPOJO getAdmin() {

		openConnection();
		transaction.begin();
		
		String jpql = "from AdminPOJO";
		query=manager.createQuery(jpql);
		List<AdminPOJO> admins = query.getResultList();
		
		if(admins.isEmpty()==false) {
		for(AdminPOJO pojo:admins) {
			transaction.commit();
			closeConnection();
			return pojo;
			
		}
		}
		
		transaction.commit();
		closeConnection();
		
		return null;
	}

	public AdminPOJO login(String username, String password) {

		openConnection();
		transaction.begin();
		
		String jpql = "from AdminPOJO where username='"+username+"' and password='"+password+"'";
		query=manager.createQuery(jpql);
		List<AdminPOJO> admins = query.getResultList();
		
		
		if(admins.isEmpty()==false) {
		for(AdminPOJO pojo:admins) {
			transaction.commit();
			closeConnection();
			return pojo;
			
		}
		}
		
		transaction.commit();
		closeConnection();
		
		return null;
	}

}
