package com.jspiders.cardekhocasestudyspringmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhocasestudyspringmvc.pojo.AdminPOJO;
import com.jspiders.cardekhocasestudyspringmvc.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public AdminPOJO createAccount(String username, String password) {

		AdminPOJO admin = repository.createAccount(username,password);
		
		return admin;
	}

	public AdminPOJO getAdmin() {

		AdminPOJO pojo = repository.getAdmin();
		
		return pojo;
	}

	public AdminPOJO login(String username, String password) {

		AdminPOJO admin = repository.login(username,password);
		
		return admin;
	}
}
