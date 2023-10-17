package com.jspiders.cardekho_case_study.operations;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.cardekho_case_study.entity.Car;
import java.util.Scanner;
public class CarOperation {
	
	private List<Car> cars;
	Scanner sc = new Scanner(System.in);
	public CarOperation() {
		cars = new ArrayList<>();
	}
	
	public void addCar(Car car) {
		cars.add(car);
		System.out.println("car added Sucessfully");
	}
	
	public void displayCars() {
		if (cars.isEmpty()) {
			System.out.println("No cars Details Available in the operation.");
		}
		else {
			System.out.println("cars to the operation : ");
			for (Car car : cars) {
				System.out.println(car);
			}
		}
	}
	
	public void updateCar(int car_id, Car updatedCar) {
		if (car_id >= 0 && car_id < cars.size()) {
			cars.set(car_id, updatedCar);
			System.out.println("Car Details updated Sucessfully!");
		}
		else {
			System.out.println("invalid car_id");
		}
	}
	
	public void deleteCar(int delete_car_id) {
		if (delete_car_id >= 0 && delete_car_id < cars.size()) {
			cars.remove(delete_car_id);
			System.out.println("car deleted sucessfully");
		}
		else {
			System.out.println("invalid car_id");
		}
		
	}
	
	
	public void addCar() {
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
		((CarOperation) cars).addCar(car);
	
	}
	
	public void updateCars() {
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
		((CarOperation) cars).updateCar(update_car_id, updatedCar);
	
		
	}
	
	public void deleteCar() {
		System.out.println("Enter the car_id to delete the car details : ");
		int delete_car_id = sc.nextInt();
		sc.nextLine();
		
		((CarOperation) cars).deleteCar(delete_car_id);
	
	}
	
}
