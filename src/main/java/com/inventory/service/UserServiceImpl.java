package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.UserDAO;
import com.inventory.model.Login;
import com.inventory.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(User user) {

		userDAO.addUser(user);

	}

	@Override
	public List<User> getAllUsers(String specs, String orderBy) {

		return userDAO.getAllUsers(specs, orderBy);
	}

	@Override
	public void deleteUser(Integer userId) {

		userDAO.deleteUser(userId);
	}

	@Override
	public User getUserById(int userId) {

		return userDAO.getUserById(userId);
	}

	@Override
	public User updateUserById(User UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User authenticateUser(Login login) {

		User user = getUserByUserName(login.getUsername());

		if (null == user || (null != user.getEpassword() && !login.getPassword().equals(user.getEpassword()))) {
			return null;
		}
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public User getUserByUserName(String userName) {

		return userDAO.getUserByUserName(userName);
	}

}
