package com.pharmacy.repos;

import java.util.List;

import com.pharmacy.model.User;

public interface UserRepository 
{
	User getUserByEmail(String email);
	User getUserByEmailAndPassword(String email, String password);
	List<User> getAllUsers();
	User saveUser(User user);
	User updateUser(User user);
	int deleteUser(String email);
	
}
