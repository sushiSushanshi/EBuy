package com.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.User;
import com.api.repository.UserRepo;
import com.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User register(User user) {
		User u1 = userRepo.save(user);
		return u1;
	}
	
	
}
