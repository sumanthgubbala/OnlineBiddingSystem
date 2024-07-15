package com.sumanth.springboot.serviceimpl;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sumanth.springboot.model.Users;
import com.sumanth.springboot.payload.UserDto;
import com.sumanth.springboot.repository.UsersRepository;
import com.sumanth.springboot.service.UsersService;

@Service
public class UserSerivceImpl implements UsersService{

	@Autowired
	private UsersRepository userrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	//private PasswordEncoder pass;
	
	@Override
	public UserDto createUser(UserDto userdto) {
		Users user=modelmapper.map(userdto,Users.class);//convert userdto to users
		Users saveduser =userrepo.save(user);
		return modelmapper.map(saveduser,UserDto.class);
	}
	
	

	

	

	

}
