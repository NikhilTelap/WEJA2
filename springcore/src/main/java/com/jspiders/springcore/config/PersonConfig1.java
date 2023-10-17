package com.jspiders.springcore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jspiders.springcore.bean.PersonBean1;

@ComponentScan(basePackages = "com.jspiders.springcore")
public class PersonConfig1 {
	
	@Bean
	public PersonBean1 getPerson() {
		return new PersonBean1();
		
	}

}
