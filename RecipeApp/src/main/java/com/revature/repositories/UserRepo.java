package com.revature.repositories;

import com.revature.entities.User;

public interface UserRepo {

	User findByCredential(String username, String password);
	
	User registration(User newUser);
	
	int userId(String username, String password);

}
