package com.jspiders.cardekhocasestudyspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhocasestudyspringmvc.pojo.CarPOJO;
import com.jspiders.cardekhocasestudyspringmvc.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(String name, String brand, String fuelType, long price) {

		CarPOJO car = repository.addCar(name,brand,fuelType,price);
		return car;
	}

	public List<CarPOJO> findAllCars() {

		
		List<CarPOJO> cars = repository.findAllCars();		
		return cars;
	}

	public CarPOJO searchCar(int id) {

		CarPOJO car = repository.searchCar(id);
		return car;
	}

	public CarPOJO removeStudent(int id) {
		CarPOJO car = repository.removeStudent(id);
		
		return car;
	}

	public CarPOJO updateCar(int id, String name, String brand, String fuelType, long price) {

		CarPOJO car = repository.updateCar(id,name,brand,fuelType,price);
		return car;
	}

	
	
	
	
}
