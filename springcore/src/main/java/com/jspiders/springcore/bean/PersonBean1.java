package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class PersonBean1 {
	
	@Value("1")
	private int id;
	
	@Value("aman")
	private String name;
	
	@Autowired
	private AadharBean1 aadhar;

}
