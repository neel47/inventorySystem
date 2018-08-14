package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.UserProjecstDAO;
import com.inventory.model.UserProjects;

@Service("userProjectsService")
@Transactional
public class UserProjectsServiceImpl implements UserProjectsService {

	@Autowired
	private UserProjecstDAO userProjectsDAO;

	@Override
	public void addUserProjects(UserProjects userProjects) {
		userProjectsDAO.addUserProjects(userProjects);

	}

	@Override
	public List<UserProjects> getAllUserProjects(String specs, String orderBy) {
		return userProjectsDAO.getAllUserProjects(specs, orderBy);
	}

	@Override
	public void deleteUserProjects(Integer userProjectsId) {
		userProjectsDAO.deleteUserProjects(userProjectsId);

	}

	@Override
	public UserProjects getUserProjectsById(int userProjectsId) {
		return userProjectsDAO.getUserProjectsById(userProjectsId);
	}

	@Override
	public UserProjects updateUserProjectsById(UserProjects userProjectsId) {
		// TODO Auto-generated method stub
		return userProjectsDAO.updateUserProjectsById(userProjectsId);
	}

	@Override
	public String userIdUnderHimById(String category, int himId) {
		// TODO Auto-generated method stub
		return userProjectsDAO.userIdUnderHimById(category, himId);
	}

	@Override
	public String userIdInTable(String category) {
		// TODO Auto-generated method stub
		return userProjectsDAO.userIdInTable(category);
	}

	@Override
	public String supervisorIdFromUserId(String category, int himId) {
		// TODO Auto-generated method stub
		return userProjectsDAO.supervisorIdFromUserId(category, himId);
	}

}
