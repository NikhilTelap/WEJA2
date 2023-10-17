package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBean1 {
	
	@Value("1")
	private int id;
	
	@Value("amit")
	private String name;
	
	@Value("wakad")
	private String address;
	
	@Value("amit@gmail.com")
	private String email;
	
	
}
