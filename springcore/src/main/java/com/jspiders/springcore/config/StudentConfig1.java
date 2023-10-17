package com.jspiders.springcore.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcore.bean.StudentBean1;

public class StudentConfig1 {
	@Bean
	public StudentBean1 getStudent() {
		
		StudentBean1 student1= new StudentBean1();
		student1.setId(1);
		student1.setName("arjun");
		student1.setEmail("arjun@gmail.com");
		return student1;
		
	}

}
