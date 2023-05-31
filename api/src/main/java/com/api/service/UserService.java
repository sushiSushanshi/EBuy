package com.api.service;

import com.api.entities.User;


public interface UserService {
	//boolean authenticate(String email , String password);
	User register(User user);
}
