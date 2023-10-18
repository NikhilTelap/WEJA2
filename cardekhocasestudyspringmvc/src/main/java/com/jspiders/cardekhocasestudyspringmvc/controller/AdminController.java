package com.jspiders.cardekhocasestudyspringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.cardekhocasestudyspringmvc.pojo.AdminPOJO;
import com.jspiders.cardekhocasestudyspringmvc.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	
	@GetMapping("/createAccount")
	public String createAccount(ModelMap map) {
		
		AdminPOJO pojo = service.getAdmin();
		
		if(pojo != null) {
			map.addAttribute("msg", "Account already exists");
			return "Login";
		}
		return "CreateAccount";
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,
								@RequestParam String password,ModelMap map) {
		
		AdminPOJO admin = service.createAccount(username,password);
		
		if(admin != null) {
			map.addAttribute("msg","Account has been created");
			return "Login";
		}
		map.addAttribute("msg","Account not created");

		return "Login";
	}
	
	
	
	@GetMapping("/login")
	public String loginPage() {
		return "Login";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam String username,
						@RequestParam String password,ModelMap map,HttpSession session) {
		AdminPOJO admin = service.login(username,password);
		
		if(admin != null) {
			session.setAttribute("login", admin);
			map.addAttribute("msg", "Login successful");
			return "Home";
			
		}
		map.addAttribute("msg", "Incorrect Username or password");

		return "Login";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Login";
	}

}
