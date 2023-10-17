package com.jspiders.cardekho_case_study.operations;



import java.util.ArrayList;
import java.util.List;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {
	
	private List<Car> cars;
	
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
}
