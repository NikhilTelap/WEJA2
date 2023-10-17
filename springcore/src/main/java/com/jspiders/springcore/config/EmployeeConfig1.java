package com.jspiders.springcore.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcore.bean.EmployeeBean1;

public class EmployeeConfig1 {
	
	@Bean
	public EmployeeBean1 getEmployee() {
		
		 EmployeeBean1 employee1 = new EmployeeBean1();
		 
		 return employee1;
		
	}

}
