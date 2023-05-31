package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.config.AuthorizedUserDetails;
import com.api.entities.Authorized;
import com.api.service.AuthorizedUserDetailService;

@RestController
@RequestMapping("/security")
public class AuthoritiesController {
	@Autowired
	private AuthorizedUserDetailService authorizedUserDetails;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public Authorized addAuthorities(@RequestBody Authorized user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Authorized authorizedUser =authorizedUserDetails.addAuthorities(user);
		return authorizedUser;
	}

}
