package com.jspiders.finalmock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.finalmock.pojo.EmployeePOJO;
import com.jspiders.finalmock.service.EmployeeService;

@Controller

public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/addPage")
	public String addPage() {
		
		return "AddPage";
	}
	
	
	@PostMapping("/addPage")
	public String addEmployee(@RequestParam String name ,
								ModelMap map) {
		
		EmployeePOJO employee = service.addEmployee(name);
		
		if(employee !=  null) {
			map.addAttribute("msg", "EMPLOYEE ADDED SUCCESSFULLY..");
			
			List<EmployeePOJO> employees = service.findAllEmployees();
			map.addAttribute("employees", employees);

			return "AddPage";
		}
		return "AddPage";
	}
	
	
	@PostMapping("/searchPage")
	public String searchPattern(@RequestParam String pattern,ModelMap map) {
		
		List<EmployeePOJO> employees = service.searchPattern(pattern);
		
		if(employees.isEmpty()==false) {
        map.addAttribute("msg", "EMPLOYEE FOUND SUCCESSFULLY..");
			
		
			map.addAttribute("employees", employees);

			return "SearchPage";
		}
		map.addAttribute("msg", "NO EMPLOYEE PRESENT..");
		return "SearchPage";
		
	}
}
