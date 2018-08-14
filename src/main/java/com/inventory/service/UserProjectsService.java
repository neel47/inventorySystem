package com.inventory.service;

import java.util.List;

import com.inventory.model.UserProjects;

public interface UserProjectsService {

	public void addUserProjects(UserProjects userProjects);

	public List<UserProjects> getAllUserProjects(String specs, String orderBy);

	public void deleteUserProjects(Integer userProjectsId);

	public UserProjects getUserProjectsById(int userProjectsId);

	public UserProjects updateUserProjectsById(UserProjects userProjectsId);

	public String userIdUnderHimById(String category, int himId);

	public String userIdInTable(String category);
	
	public String supervisorIdFromUserId(String category,int himId);

}
