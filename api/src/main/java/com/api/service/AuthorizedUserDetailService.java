package com.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.config.AuthorizedUserDetails;
import com.api.entities.Authorized;
import com.api.repository.AuthorizedRepo;


@Component
public class AuthorizedUserDetailService implements UserDetailsService {

	@Autowired
	private AuthorizedRepo authorizedRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Authorized> auth= authorizedRepo.findByUsername(username);
		
		return auth.map(AuthorizedUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not for found "+username));
	}
	
	public Authorized addAuthorities(Authorized user) {
		Authorized authorized =authorizedRepo.save(user);
		return authorized;
	}

}
