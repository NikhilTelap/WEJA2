package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore.bean.EmployeeBean1;

import com.jspiders.springcore.config.EmployeeConfig1;


public class EmployeeMain {
public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig1.class);
		
		EmployeeBean1 employee1 = context.getBean(EmployeeBean1.class);
		System.out.println(employee1);
		
		((AnnotationConfigApplicationContext)context).close();
		
	}

}
