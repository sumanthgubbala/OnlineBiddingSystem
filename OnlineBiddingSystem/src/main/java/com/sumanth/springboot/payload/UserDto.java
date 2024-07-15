package com.sumanth.springboot.payload;

import java.time.LocalDateTime;

import com.sumanth.springboot.model.Users.Role;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UserDto {
	
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Role role;
	
	private LocalDateTime createdAt;

}