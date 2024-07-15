package com.sumanth.springboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.*;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.springboot.model.Users;
import com.sumanth.springboot.payload.UserDto;
import com.sumanth.springboot.repository.UsersRepository;
//import com.sumanth.springboot.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	//private UsersService userservice;
	
	UsersRepository userrepo;
	     
    
	@PostMapping("/api/user")
    public ResponseEntity<Users> insert(@RequestBody Users user) {
    	return new ResponseEntity<>(userrepo.save(user),HttpStatus.CREATED);
    	
    }
    
    @PutMapping
    public String putMethod() {
    	return "put method";
    }
	
    @GetMapping("/api/user")
    public ResponseEntity<List<Users>> display() {
    	return new ResponseEntity<>(userrepo.findAll(),HttpStatus.OK);
    }
    
    @GetMapping("/api/user/{id}")
    public ResponseEntity<Users> dislaybyid(@PathVariable long id) {
    	java.util.Optional<Users> user=userrepo.findById(id);
    	
    	if(user.isPresent()) {
    		return new ResponseEntity<>(user.get(),HttpStatus.OK);
    		
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @PutMapping("/api/user/restpassword/{id}")
    public ResponseEntity<Users> update(@PathVariable long id,@RequestBody UserDto users) {
    	java.util.Optional<Users> user=userrepo.findById(id);
    	
    	
    	if(user.isPresent()) {
    		Users existingUser = user.get();
            if (users.getPassword() != null && !users.getPassword().isEmpty()) {
                userrepo.updatePassword(id, users.getPassword());
                return new ResponseEntity<>(userrepo.save(existingUser), HttpStatus.OK);
            }
            else {
            	 return new ResponseEntity<>(user.get(), HttpStatus.BAD_REQUEST); // Password should not be null or empty
            }
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @PutMapping("/api/user/updateemail/{id}")
    public ResponseEntity<String> tset(@PathVariable long id, @RequestBody UserDto users) {
    	java.util.Optional<Users> user=userrepo.findById(id);
    	if(user.isPresent()) {
    		userrepo.upadateEmai(id, users.getEmail());
    		return new ResponseEntity<>("user email updtaed", HttpStatus.OK);
    		
    	}
        
        return new ResponseEntity<>("Check the console for the received user", HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping("/api/user/delete/{id}")
    public ResponseEntity<Void> delteMethod(@PathVariable long id ) {
    	java.util.Optional<Users> user=userrepo.findById(id);
    	if(user.isPresent()) {
    		userrepo.deleteById(id);
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
