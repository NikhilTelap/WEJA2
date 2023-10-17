package com.jspiders.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	private int id;
	private String name;
	private String email;
	
	@OneToOne
	private AadharCard aadharcard;

	
	
	

}
