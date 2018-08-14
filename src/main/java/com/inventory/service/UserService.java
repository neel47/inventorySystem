package com.inventory.service;

import java.util.List;

import com.inventory.model.Login;
import com.inventory.model.User;


public interface UserService {
	
	public void addUser(User user);

	public List<User> getAllUsers(String specs,String orderBy);

	public void deleteUser(Integer userId);

	public User getUserById(int userId);

	public User updateUserById(User UserId);
	
	public User authenticateUser(Login login);
	
	public User getUserByUserName(String userName);

}
