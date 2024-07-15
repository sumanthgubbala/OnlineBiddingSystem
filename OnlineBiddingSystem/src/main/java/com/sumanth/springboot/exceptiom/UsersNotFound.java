package com.sumanth.springboot.exceptiom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class UsersNotFound extends RuntimeException {
	private String message;
	
	public UsersNotFound(String message) {
		super(message);
		this.message=message;
	}

}
