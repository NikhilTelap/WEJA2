package com.jspiders.cardekhocasestudyspringmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekhocasestudyspringmvc.pojo.CarPOJO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Repository
public class CarRepository {

private static EntityManagerFactory factory;
private static EntityManager manager;
private static EntityTransaction transaction;
private static Query query;

private static void openConnection() {
	factory=Persistence.createEntityManagerFactory("cdcs");
	manager = factory.createEntityManager();
	transaction = manager.getTransaction();
}

private static void closeConnection() {
	
	if(factory!=null) {
		factory.close();
	}
	if(manager !=null) {
		manager.close();
	}
	if(transaction != null) {
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
}
	
	
	public CarPOJO addCar(String name, String brand, String fuelType,long price) {
		
		openConnection();
		transaction.begin();
		
		CarPOJO car = new CarPOJO();
		car.setName(name);
		car.setBrand(brand);
		car.setFuelType(fuelType);
		car.setPrice(price);
		
		manager.persist(car);
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public List<CarPOJO> findAllCars() {

		openConnection();
		transaction.begin();
		
		String jpql ="from CarPOJO";
		query=manager.createQuery(jpql);
		List<CarPOJO> cars = query.getResultList();
		
		transaction.commit();
		closeConnection();
		
		return cars;
	}

	public CarPOJO searchCar(int id) {

		openConnection();
		transaction.begin();
		
		CarPOJO car = manager.find(CarPOJO.class, id);
		
		transaction.commit();
		closeConnection();
		
		return car;
	}

	public CarPOJO removeStudent(int id) {

		openConnection();
		transaction.begin();
		
		CarPOJO car = manager.find(CarPOJO.class, id);
			manager.remove(car);
		transaction.commit();
		closeConnection();
		
		return car;
	}

	public CarPOJO updateCar(int id, String name, String brand, String fuelType, long price) {
		
		openConnection();
		transaction.begin();
		
	CarPOJO car =manager.find(CarPOJO.class,id);
		car.setName(name);
		car.setBrand(brand);
		car.setFuelType(fuelType);
		car.setPrice(price);
		
		manager.persist(car);
		
		transaction.commit();
		closeConnection();
		return car;
	}

	
}
