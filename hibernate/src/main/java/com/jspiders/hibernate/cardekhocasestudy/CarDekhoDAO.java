package com.jspiders.hibernate.cardekhocasestudy;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class CarDekhoDAO {

	
		private static EntityManagerFactory entityManagerFactory;
		private static EntityManager entityManager;
		private static EntityTransaction entityTransaction;
		static Scanner scanner = new Scanner(System.in);

	static boolean loop=true;

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
	
	private static void addCarDetails() {
		
		System.out.println("How many cars you want to enter");
		int noOfCars=scanner.nextInt();
		
		for(int i=0;i<noOfCars;i++) {
			CarDTO car1 = new CarDTO();
			System.out.println("Enter car id:");
			car1.setCar_id(scanner.nextInt());
			
			System.out.println("Enter car name:");
			car1.setName(scanner.next());
			
			System.out.println("Enter car Brand:");
			car1.setBrand(scanner.next());
			
			System.out.println("Enter car fuel_type:");
			car1.setFuel_type(scanner.next());
			
			System.out.println("Enter car price:");
			car1.setPrice(scanner.nextLong());
			
			entityManager.persist(car1);
	}
	}
		
		public static void main(String[] args) {
			
		
		while(loop) {
			carDekhoMenu();
			
		}
		}
		private static void carDekhoMenu() {
			
			System.out.println("=====MENU====\n"+
								"1.Add Car Details\n"+
								"2.Remove Car Details\n"+
								"3.Find Car Details\n"+
								"4.Edit Car Details\n"+
								"5.Exit");
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n Enter your choice:");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1: 
					openConnection();
					entityTransaction.begin();
					
					addCarDetails();
					
					entityTransaction.commit();
					closeConnection();
					break;
			case 2:
				openConnection();
				entityTransaction.begin();
				CarDTO carDTO = new CarDTO();
				System.out.println(carDTO);
				System.out.println("Enter car id you want to delete");
				int remove=scanner.nextInt();
				
				CarDTO cardto = entityManager.find(CarDTO.class, remove);
				entityManager.remove(cardto);
				
				entityTransaction.commit();
				closeConnection();
					break;
			case 3:openConnection();
			entityTransaction.begin();
		
			System.out.println("Enter car id you want to find:");
			int find=scanner.nextInt();
			CarDTO cardto2 = entityManager.find(CarDTO.class, find);		
	
			entityTransaction.commit();
			closeConnection();
					break;
		
			case 4:
				openConnection();
				entityTransaction.begin();
				System.out.println("Enter car id you want to update:");
				int update = scanner.nextInt();
				CarDTO cardto1 = entityManager.find(CarDTO.class, update);
				
				System.out.println("Enter car id:");
				cardto1.setCar_id(scanner.nextInt());
				
				System.out.println("Enter car name:");
				cardto1.setName(scanner.next());
				
				System.out.println("Enter car Brand:");
				cardto1.setBrand(scanner.next());
				
				System.out.println("Enter car fuel_type:");
				cardto1.setFuel_type(scanner.next());
				
				System.out.println("Enter car price:");
				cardto1.setPrice(scanner.nextLong());
				
				entityTransaction.commit();
				closeConnection();

					break;
			case 5:	
					System.out.println("Thank you !! Visit again..");
					loop=false;
					scanner.close();
					break;
					
					
			default:System.out.println("Enter valid choice");
			
			}

	}
	}


