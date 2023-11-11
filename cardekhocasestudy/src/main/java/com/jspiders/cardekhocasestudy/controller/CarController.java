package com.jspiders.cardekhocasestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekhocasestudy.pojo.CarPOJO;
import com.jspiders.cardekhocasestudy.response.CarResponse;
import com.jspiders.cardekhocasestudy.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService service;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> AddCar(@RequestBody CarPOJO pojo){
		
		CarPOJO car = service.addCar(pojo);
		
		if(car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("car added successfully..", car, null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car not found..", car, null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("searchById/{id}")
	public ResponseEntity<?> searchById(@PathVariable int id){
		
		CarPOJO car = service.findById(id);
		
		if(car != null) {
			
		return new	ResponseEntity<CarResponse>(new CarResponse("car found successfully..", car, null),HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car not found", car, null),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("searchByName/{name}")
	public ResponseEntity<?> searchByName(@PathVariable String name){
		
		List<CarPOJO> cars = service.findByName(name);
		
		if(cars.isEmpty()==false) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car found successfully..", null, cars),HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car not found.", null, cars),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("searchByBrand/{brand}")
	public ResponseEntity<?> searchByBrand(@PathVariable String brand){
		
		List<CarPOJO> cars = service.findByBrand(brand);
		
		if(cars.isEmpty()==false) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car found successfully..", null, cars),HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car not found.", null, cars),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("searchByFuelType/{fuelType}")
	public ResponseEntity<?> searchByFuelType(@PathVariable String fuelType){
		
		List<CarPOJO> cars = service.findByFuelType(fuelType);
		
		if(cars.isEmpty()==false) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car found successfully..", null, cars),HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car not found.", null, cars),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("searchAll")
	public ResponseEntity<?> searchAll(){
		
		List<CarPOJO> cars = service.findAll();
		
		if(cars.isEmpty()==false) {
			return new ResponseEntity<CarResponse>(new CarResponse("cars found successfully", null, cars),HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse> (new CarResponse("cars not found", null, cars),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("remove/{id}")
	public ResponseEntity<?> removeCar(@PathVariable int id){
		
		CarPOJO car = service.deleteCar(id);
		
		if(car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("car deleted successfully", car, null),HttpStatus.ACCEPTED);
		}
		return  new ResponseEntity<CarResponse>(new CarResponse("Car not deleted", car, null),HttpStatus.BAD_REQUEST);
				
	}

	@PostMapping("update")
	public ResponseEntity<?> updateCar(@RequestBody CarPOJO pojo){
		
		CarPOJO car = service.updateCar(pojo);
		
		if(car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("car updated successfully", car, null),HttpStatus.ACCEPTED);
			
		}
		return new ResponseEntity<CarResponse>(new CarResponse("car not updated ", car, null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
}
