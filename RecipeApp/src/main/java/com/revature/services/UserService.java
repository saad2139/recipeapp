package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.User;
import com.revature.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
	public User login(String username, String password) {
		return ur.findByCredential(username,password);
	}

	public User registration(User u) {
		return ur.registration(u);
	}
	


}
