package com.sumanth.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.springboot.payload.UserDto;
import com.sumanth.springboot.service.UsersService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UsersService userservice;
	
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto userdto) {
		return new ResponseEntity<>(userservice.createUser(userdto),HttpStatus.CREATED);
		
		
		
	}
	
	
	
	

}
