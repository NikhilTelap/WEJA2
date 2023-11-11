package com.jspiders.cardekhocasestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhocasestudy.pojo.CarPOJO;
import com.jspiders.cardekhocasestudy.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(CarPOJO pojo) {

		CarPOJO car = repository.save(pojo);
		return car;
	}

	public CarPOJO findById(int id) {

		CarPOJO car = repository.findById(id).orElse(null);
		return car;
	}

	public List<CarPOJO> findByName(String name) {

		List<CarPOJO> cars = repository.findByName(name);
		return cars;
	}

	public List<CarPOJO> findByBrand(String brand) {

		List<CarPOJO> cars = repository.findByBrand(brand);
		return cars;
	}

	public List<CarPOJO> findByFuelType(String fuelType) {

		List<CarPOJO> cars  = repository.findByFuelType(fuelType);
		return cars;
	}

	public List<CarPOJO> findAll() {

		List<CarPOJO> cars = repository.findAll();
		return cars;
	}

	public CarPOJO deleteCar(int id) {

			CarPOJO car = repository.findById(id).orElse(null);
			
			if(car != null) {
				repository.delete(car);
				return car;
			}
		return null;
	}

	public CarPOJO updateCar(CarPOJO pojo) {

		CarPOJO car = repository.findById(pojo.getId()).orElse(null);
			if(car != null) {
				car.setName(pojo.getName());
				car.setBrand(pojo.getBrand());
				car.setFuelType(pojo.getFuelType());
				car.setPrice(pojo.getPrice());
				
				repository.save(car);
				return car;
				
			}
			
		return null;
	}
}
