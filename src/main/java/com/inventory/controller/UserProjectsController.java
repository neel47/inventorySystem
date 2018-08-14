package com.inventory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inventory.model.Project;
import com.inventory.model.User;
import com.inventory.model.UserProjects;
import com.inventory.service.ProjectService;
import com.inventory.service.UserProjectsService;
import com.inventory.service.UserService;

@Controller
public class UserProjectsController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserProjectsService userProjectsService;

	@RequestMapping(value = "/UserProjectsCreation")
	public ModelAndView projectCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {

		String from = request.getParameter("from");
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		List<User> users = null;
		List<User> usersAdded = null;
		if ("PROJECTMANAGER".equals(user.getEcategory())) {

			if ("add".equals(from)) {
				String idOfUserinTable = userProjectsService.userIdInTable("PROJECTMANAGER");
				if(!idOfUserinTable.isEmpty())
				users = userService.getAllUsers("SUPERVISOR:ecategory&" + idOfUserinTable + ":!id", " id desc ");
				else
				users = userService.getAllUsers("SUPERVISOR:ecategory", " id desc ");	
			} else {
				String idOfUserUnder = userProjectsService.userIdUnderHimById("PROJECTMANAGER", user.getId());
				if(!idOfUserUnder.isEmpty())
				usersAdded = userService.getAllUsers("SUPERVISOR:ecategory&" + idOfUserUnder + ":^id", " id desc ");
			}
		} else {
			if ("add".equals(from)) {
				String idOfUserinTable = userProjectsService.userIdInTable("SUPERVISOR");
				if(!idOfUserinTable.isEmpty())
				users = userService.getAllUsers("EMPLOYEE:ecategory&" + idOfUserinTable + ":!id", " id desc ");
				else
					users = userService.getAllUsers("EMPLOYEE:ecategory", " id desc ");	
			} else {
				String idOfUserUnder = userProjectsService.userIdUnderHimById("SUPERVISOR", user.getId());
				if(!idOfUserUnder.isEmpty())
				usersAdded = userService.getAllUsers("EMPLOYEE:ecategory&" + idOfUserUnder + ":^id", " id desc ");
			}
		}
		if ("add".equals(from))
			model.addObject("users", users);
		else
			model.addObject("users", usersAdded);

		model.addObject("from", from);
		model.setViewName("UserProjectsForm");
		return model;
	}

	@RequestMapping(value = "/addUserInProject")
	public ModelAndView save(ModelAndView model, HttpServletRequest request) throws IOException {

		int userIdToAdd = Integer.parseInt(request.getParameter("id"));
		UserProjects userProjects = new UserProjects();
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		Project projectInfoOfUser;
		if ("PROJECTMANAGER".equals(user.getEcategory())) {
			userProjects.setCategory("SUPERVISOR");
			projectInfoOfUser = projectInfoOfUser = projectService
					.getAllProjects(user.getId() + ":managerid", " id desc ").get(0);
		} else {
			userProjects.setCategory("EMPLOYEE");
			userProjects.setSupervisorid(user.getId());
			UserProjects userProjectsOfSuperviosr=userProjectsService.getAllUserProjects(user.getId()+":userid&SUPERVISOR:category", " id desc ").get(0);
			projectInfoOfUser = projectInfoOfUser = projectService
					.getAllProjects(userProjectsOfSuperviosr.getManagerid() + ":managerid", " id desc ").get(0);
		}

		userProjects.setUserid(userIdToAdd);
		userProjects.setProjectid(projectInfoOfUser.getID());
		userProjects.setManagerid(projectInfoOfUser.getManagerid());
		userProjects.setRegionalmanagerid(projectInfoOfUser.getRegionalmanagerid());
		String sid = request.getSession().getId();
		userProjectsService.addUserProjects(userProjects);

		model.setViewName("redirect:/UserProjectsCreation?from=add");
		return model;
	}

	@RequestMapping(value = "/UserProjectsList")
	public ModelAndView ProjectList(ModelAndView model, HttpServletRequest request) throws IOException {

		StringBuilder specs = new StringBuilder();
		if (null != request.getParameter("category")) {
			String category = (String) request.getParameter("category");
			specs.append(category);
			specs.append(":ecategory,");
		}

		List<Project> projectList = projectService.getAllProjects(specs.toString(), " id desc  ");
		String sid = request.getSession().getId();
		model.addObject("projectList", projectList);
		model.setViewName("x");
		return model;
	}

	@RequestMapping(value = "/editUserProjects")
	public ModelAndView editProject(ModelAndView model, HttpServletRequest request) throws IOException {

		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectService.getProjectById(projectId);
		String sid = request.getSession().getId();
		List<User> userListRM = userService.getAllUsers("REGIONALMANAGER:ecategory", " id desc ");
		List<User> userListPM = userService.getAllUsers("PROJECTMANAGER:ecategory", " id desc ");
		model.addObject("projectmanager", userListPM);
		model.addObject("regionalprojectmanager", userListRM);
		model.addObject("project", project);
		model.setViewName("x");
		return model;
	}

	@RequestMapping(value = "/deleteUserInProject")
	public ModelAndView deleteProject(ModelAndView model, HttpServletRequest request) throws IOException {

		int userId = Integer.parseInt(request.getParameter("id"));
		UserProjects userProjects = userProjectsService.getAllUserProjects(userId + ":userid", " id desc ").get(0);
		userProjectsService.deleteUserProjects(userProjects.getId());
		model.setViewName("redirect:/UserProjectsCreation?from=delete");
		return model;
	}

}
