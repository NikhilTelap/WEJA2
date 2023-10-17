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
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter Your Choices : ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) {
		case 1:operation.addCar();
				break;

		case 2:operation.displayCars();
			break;
			
		case 3:operation.updateCars();
				break;
			
		case 4:operation.deleteCar();
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