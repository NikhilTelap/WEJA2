package com.jspiders.cardekhocasestudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhocasestudy.pojo.AdminPOJO;
import com.jspiders.cardekhocasestudy.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository; 
	public AdminPOJO createAccount(AdminPOJO pojo) {

		AdminPOJO admin = repository.save(pojo);
		return admin;
	}
	public AdminPOJO login(AdminPOJO pojo) {

		AdminPOJO admin = repository.findById(pojo.getUsername()).orElse(null);
		
		if(pojo.getPassword().equals(admin.getPassword())) {
			
			return admin;
		}
		return null;
	}

}
