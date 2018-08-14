package com.inventory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inventory.model.Project;
import com.inventory.model.User;
import com.inventory.service.ProjectService;
import com.inventory.service.UserService;

@Controller
public class ProjectController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/ProjectCreation")
	public ModelAndView projectCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Project project = new Project();
		List<User> userListRM = userService.getAllUsers("REGIONALMANAGER:ecategory", " id desc ");
		List<User> userListPM = userService.getAllUsers("PROJECTMANAGER:ecategory", " id desc ");
		String sid = request.getSession().getId();
		model.addObject("projectmanager", userListPM);
		model.addObject("regionalprojectmanager", userListRM);
		model.addObject("project", project);
		model.setViewName("ProjectForm");
		return model;
	}

	@RequestMapping(value = "/ProjectCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("project") Project project,
			BindingResult result, HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in Project Controller");
		}

		projectService.addProject(project);
		model.setViewName("redirect:/ProjectList");
		return model;
	}

	@RequestMapping(value = "/ProjectList")
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
		model.setViewName("ProjectList");
		return model;
	}

	@RequestMapping(value = "/editProject")
	public ModelAndView editProject(ModelAndView model, HttpServletRequest request) throws IOException {

		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectService.getProjectById(projectId);
		String sid = request.getSession().getId();
		List<User> userListRM = userService.getAllUsers("REGIONALMANAGER:ecategory", " id desc ");
		List<User> userListPM = userService.getAllUsers("PROJECTMANAGER:ecategory", " id desc ");
		model.addObject("projectmanager", userListPM);
		model.addObject("regionalprojectmanager", userListRM);
		model.addObject("project", project);
		model.setViewName("ProjectForm");
		return model;
	}

	@RequestMapping(value = "/deleteProject")
	public ModelAndView deleteProject(ModelAndView model, HttpServletRequest request) throws IOException {

		int projectId = Integer.parseInt(request.getParameter("id"));
		projectService.deleteProject(projectId);
		model.setViewName("redirect:/ProjectList");
		return model;
	}

}
