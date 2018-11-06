package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User addUser(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> listUser(){
		return userRepository.findAll();
	}
	
	
	public void deleteUser(Integer uId)
	{
		userRepository.deleteById(uId);
	}
	
	public User updateUser(Integer uId, User user)
	{
		User userone= userRepository.getOne(uId);
		userone.setFirstName(user.getFirstName());
		userone.setLastName(user.getLastName());
		userone.setEmail(user.getEmail());
		return userRepository.save(userone);
		
	}
	
	
	

}
