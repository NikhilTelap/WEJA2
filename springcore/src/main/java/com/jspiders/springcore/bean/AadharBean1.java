package com.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component

public class AadharBean1 {
	
	@Value("1")
	private int id;
	
	@Value("123456798765")
	private String aadharNo;

}
