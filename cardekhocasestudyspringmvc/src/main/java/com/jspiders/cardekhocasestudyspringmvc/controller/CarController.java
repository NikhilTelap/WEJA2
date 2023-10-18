package com.jspiders.cardekhocasestudyspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.cardekhocasestudyspringmvc.pojo.AdminPOJO;
import com.jspiders.cardekhocasestudyspringmvc.pojo.CarPOJO;
import com.jspiders.cardekhocasestudyspringmvc.service.CarService;

@Controller
public class CarController {

		@Autowired
		private CarService service;
		
		@GetMapping("/home")
		public String homePage(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
			if(admin != null) {
			return"Home";
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
		@GetMapping("/add")
		public String addPage(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
			if(admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars",cars);
			return "Add";
			}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
		
		@PostMapping("/add")
		public String addCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam String name,
						@RequestParam String brand,
						@RequestParam String fuelType,
						@RequestParam long price,ModelMap map) {
	
			if(admin != null) {
			CarPOJO car = service.addCar(name,brand,fuelType,price);
			
			if(car != null) {
				map.addAttribute("msg", "Car Added Successfully..");
				map.addAttribute("car", car);
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars",cars);
				return "Add";
			}
			map.addAttribute("msg", "car not added");
			return "Add";
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
		
		
		@GetMapping("/update")  
		public String updatePage(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
			
			if(admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars",cars);
			
			return "Update";
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
		
		@PostMapping("/update")
		public String updatePage(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,ModelMap map) {
		
			if(admin != null) {
			CarPOJO car = service.searchCar(id);
			
			if(car != null) {
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars",cars);

				map.addAttribute("car", car);
				return "Update";
			}
			map.addAttribute("msg", "Car not found");
			return "Update";
			
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
		
		
		@PostMapping("/updateCar")
		public String updateCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,
									@RequestParam String name,
									@RequestParam String brand,
									@RequestParam String fuelType,
									@RequestParam long price,
									ModelMap map) {
			
			if(admin  != null) {
			CarPOJO car = service.updateCar(id,name,brand,fuelType,price);
			
			if(car != null) {
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars",cars);
				map.addAttribute("msg","car has been updated");
				return "Update";
			}
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars",cars);
			map.addAttribute("msg","car not updated");
			return "Update";
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
		
		
		@GetMapping("/search")
		public String searchPage(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		
			if(admin != null) {
			return "Search";
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
		
		
		@PostMapping("/search")
		public String searchCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,ModelMap map) {
		
			if(admin != null) {
			CarPOJO car = service.searchCar(id);
			
			if(car != null) {
			
				map.addAttribute("msg", "car found");
				map.addAttribute("car", car);
				return "Search";
			}
			map.addAttribute("msg", "Car not found");
			return "Search";
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
			
		}
		
		@GetMapping("/remove")
		public String removePage(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
			
			if(admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars",cars);
			return "Remove";
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
		
		@PostMapping("/remove")
		public String removeStudent(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id , ModelMap map)
		{
			if(admin != null) {
			CarPOJO car =service.removeStudent(id);
			
			if(car!=null) {
				map.addAttribute("msg", "Car Removed Successfully..");
				
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars",cars);
				return "Remove";
			}
			map.addAttribute("msg","car did not removed");
			return "Remove";
		}
			map.addAttribute("msg","session inactive please login..");
			return "Login";
		}
	}
