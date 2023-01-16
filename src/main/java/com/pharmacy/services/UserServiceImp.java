package com.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pharmacy.model.User;
import com.pharmacy.repos.UserRepository;

public class UserServiceImp implements UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUserByEmail(String email) 
	{
		return this.userRepository.getUserByEmail(email);
	}

	@Override
	public List<User> getAllUsers() 
	{
		return this.userRepository.getAllUsers();
	}

	@Override
	public User saveUser(User user) 
	{
		return this.userRepository.saveUser(user);
	}

	@Override
	public User updateUser(User user) 
	{
		return this.userRepository.updateUser(user);
	}

	@Override
	public int deleteUser(String email) 
	{
		return this.userRepository.deleteUser(email);
	}
	
	
	
}
