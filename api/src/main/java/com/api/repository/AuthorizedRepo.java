package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entities.Authorized;

public interface AuthorizedRepo extends JpaRepository<Authorized, Integer>{

	Optional<Authorized> findByUsername(String username);
	
}
