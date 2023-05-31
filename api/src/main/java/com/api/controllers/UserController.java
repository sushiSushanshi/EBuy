package com.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.User;
import com.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Api to register new user
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		User u1 = userService.register(user);
		System.out.println(u1);
		return u1;
	}
	
	
}
