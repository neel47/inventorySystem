package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.ProjectDAO;
import com.inventory.model.Project;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public void addProject(Project project) {
		projectDAO.addProject(project);

	}

	@Override
	public List<Project> getAllProjects(String specs, String orderBy) {
		return projectDAO.getAllProjects(specs, orderBy);
	}

	@Override
	public void deleteProject(Integer projectId) {
		projectDAO.deleteProject(projectId);

	}

	@Override
	public Project getProjectById(int projectId) {
		return projectDAO.getProjectById(projectId);
	}

	@Override
	public Project updateProjectById(Project projectId) {
		// TODO Auto-generated method stub
		return projectDAO.updateProjectById(projectId);
	}

	@Override
	public String managerIdUnderHimById(String category, int himId) {
		// TODO Auto-generated method stub
		return projectDAO.managerIdUnderHimById(category, himId);
	}

}
