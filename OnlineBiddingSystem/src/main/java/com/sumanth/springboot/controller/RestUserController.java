package com.sumanth.springboot.controller;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.springboot.model.Restuser;

@RestController
@RequestMapping("/users")
public class RestUserController {
	
	Map<String,Restuser> users=new HashMap<>();
	
	@GetMapping
	public Collection<Restuser> print(){
		return users.values();
	}
	
	@PostMapping
	public String insert(@RequestBody Restuser user) {
		
		Restuser addvalue=new Restuser();
		addvalue.setUserId(user.getUserId());
		addvalue.setName(user.getName());
		addvalue.setEmail(user.getEmail());
		users.put(user.getUserId(), addvalue);
		
		return "user inserted";
	}
	
	@DeleteMapping(path="{userId}")
	public String delete(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			users.remove(userId);
		}else {
			return "user not found";
		}
		
		return "deleted..";
	}
	
	@PutMapping(path="{userId}")
	public String update(@PathVariable String userId,@RequestBody Restuser user) {
		if(users.containsKey(userId)) {
			Restuser addvalue=new Restuser();
			addvalue.setUserId(user.getUserId());
			addvalue.setName(user.getName());
			addvalue.setEmail(user.getEmail());
			users.put(userId, addvalue);
			return "Update"+userId;
			
		}else {
			return "user not found";
		}
	}
	
	
	
	
	

}
