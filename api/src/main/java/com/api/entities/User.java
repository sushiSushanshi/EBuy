package com.api.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
	
	@Id
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	
	
}
