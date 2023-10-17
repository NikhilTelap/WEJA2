package com.jspiders.cardekho_case_study.main;

import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;
import com.jspiders.cardekho_case_study.operations.CarOperation;


public class CarDekhoCaseMenu {
	
	private static CarOperation operation = new CarOperation();
	private static boolean logo = true;
	
	public static void main(String[] args) {
		
		while(logo) {
			carDekhoMenu();
		}
	}
	
	private static void carDekhoMenu() {
		System.out.println("**************Menu******************");
		System.out.println("1. Add Car Details");
		System.out.println("2. Search Car Details");
		System.out.println("3. Update Car Details");
		System.out.println("4. Delete Car Details");
		System.out.println("5. Exit");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Your Choices : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
		case 1:
			System.out.println("Enter the car_id");
			int car_id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Car Name");
			String name = sc.nextLine();
			System.out.println("Enter the Car Model ");
			String model = sc.nextLine();
			System.out.println("Enter the Car Brand");
			String brand = sc.nextLine();
			System.out.println("Enter the car fuel_type");
			String fuel_type = sc.nextLine();
			System.out.println("Enter the car price");
			double price = sc.nextDouble();
			sc.nextLine();
			
			Car car = new Car(car_id,name,model,brand,fuel_type,price);
			operation.addCar(car);
			break;

		case 2:
			operation.displayCars();
			break;
			
		case 3:
			System.out.println("Enter the car_id to update the car details : ");
			int update_car_id = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter the update car Name : ");
			String update_name = sc.nextLine();
			System.out.println("Enter the update car Model : ");
			String update_model = sc.nextLine();
			System.out.println("Enter the update car Brand : ");
			String update_brand = sc.nextLine();
			System.out.println("Enter the update car fuel_type : ");
			String update_fueltype = sc.nextLine();
			System.out.println("Enter the update car price : ");
			double update_price = sc.nextDouble();
			sc.nextLine();
			
			Car updatedCar = new Car(update_car_id,update_name,update_model,update_brand,update_fueltype,update_price);
			operation.updateCar(update_car_id, updatedCar);
			break;
			
		case 4:
			System.out.println("Enter the car_id to delete the car details : ");
			int delete_car_id = sc.nextInt();
			sc.nextLine();
			
			operation.deleteCar(delete_car_id);
			break;
	
		case 5:
			System.out.println("Thank You.........");
			System.exit(0);
			break;
			
		default:
			System.out.println("Invalid choice. please try again.");
		}
		System.out.println();	
	}
}