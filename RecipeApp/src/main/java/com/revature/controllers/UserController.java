package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.User;
import com.revature.services.UserService;
import com.revature.transfer.objects.Credential;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService us = new UserService();


	@PostMapping("login")
	public User login(@RequestBody Credential cred) {
		return us.login(cred.getUsername(),cred.getPassword());
	}
	
	@PostMapping("register")
	public User register(@RequestBody User u) {
		return us.registration(u);
	}


}
