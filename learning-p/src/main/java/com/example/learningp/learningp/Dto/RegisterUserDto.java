package com.example.learningp.learningp.Dto;

import java.util.Set;



import com.example.learningp.learningp.entity.Courses;
import com.example.learningp.learningp.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RegisterUserDto {

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	private Set<Role> roles;

	private Set<Courses> courses;
}
