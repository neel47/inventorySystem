package com.inventory.dao;

import java.util.List;

import com.inventory.model.User;

public interface UserDAO {
	public void addUser(User user);

	public List<User> getAllUsers(String specs, String orderBy);

	public void deleteUser(Integer userId);

	public User getUserById(int userId);

	public User updateUserById(User UserId);

	public User getUserByUserName(String userName);

}
