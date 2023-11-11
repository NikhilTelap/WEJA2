package com.jspiders.cardekhocasestudy.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AdminPOJO {

	@Id
	private String username;
	private String password;
}
