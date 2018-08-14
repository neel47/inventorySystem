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
import com.inventory.model.TaskMST;
import com.inventory.model.User;
import com.inventory.model.UserProjects;
import com.inventory.service.ProjectService;
import com.inventory.service.TaskMSTService;
import com.inventory.service.UserProjectsService;
import com.inventory.service.UserService;

@Controller
public class TaskMSTController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserProjectsService userProjectsService;
	
	@Autowired
	private TaskMSTService taskMSTService;

	@RequestMapping(value = "/TaskMSTCreation")
	public ModelAndView taskMstCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {

		TaskMST taskmst=new TaskMST();
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		List<User> users = null;
		
		if ("PROJECTMANAGER".equals(user.getEcategory())) {

			
				String idOfUserUnder = userProjectsService.userIdUnderHimById("PROJECTMANAGER", user.getId());
				if(!idOfUserUnder.isEmpty())
				users = userService.getAllUsers("SUPERVISOR:ecategory&" + idOfUserUnder + ":^id", " id desc ");
				taskmst.setTaskassigneecategory("SUPERVISOR");
		} else if("SUPERVISOR".equals(user.getEcategory()))
		{
				String idOfUserUnder = userProjectsService.userIdUnderHimById("SUPERVISOR", user.getId());
				if(!idOfUserUnder.isEmpty())
				users = userService.getAllUsers("EMPLOYEE:ecategory&" + idOfUserUnder + ":^id", " id desc ");
				taskmst.setTaskassigneecategory("EMPLOYEE");
		}
		else
		{
			String idOfUserUnder = projectService.managerIdUnderHimById("REGIONALMANAGER", user.getId());
			if(!idOfUserUnder.isEmpty())
			users = userService.getAllUsers("PROJECTMANAGER:ecategory&" + idOfUserUnder + ":^id", " id desc ");
			taskmst.setTaskassigneecategory("PROJECTMANAGER");
		}
		taskmst.setTaskcreatorid(user.getId());
		taskmst.setTaskcreatorcategory(user.getEcategory());
		model.addObject("users", users);
		model.addObject("taskmst", taskmst);
		model.setViewName("TaskForm");
		return model;
	}

	@RequestMapping(value = "/TaskMSTCreationSave")
	public ModelAndView save(ModelAndView model,@Valid @ModelAttribute("taskmst") TaskMST taskmst, BindingResult result, HttpServletRequest request) throws IOException {
		
		if (result.hasErrors()) {
			System.out.println("Error in User Controller");
		}

		taskMSTService.addTaskMST(taskmst);

		model.setViewName("redirect:/TaskMstList");
		return model;
	}

	@RequestMapping(value = "/TaskMstList")
	public ModelAndView taskCreatorList(ModelAndView model, HttpServletRequest request) throws IOException {
		
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		List<TaskMST> taskMstList=null;
		
		String taskByCreaterID=taskMSTService.getAllTaskByUserID(user.getEcategory(), user.getId(),true);
		if(!taskByCreaterID.isEmpty())
		taskMstList =taskMSTService.getAllTaskMST(taskByCreaterID + ":^id", " id desc ");
		String sid = request.getSession().getId();
		model.addObject("from", "creator");
		model.addObject("taskmstList", taskMstList);
		model.addObject("titleMSG", "Task Creator List");
		model.setViewName("TaskMstList");
		return model;
	}
	
	@RequestMapping(value = "/TaskMstAssigneeList")
	public ModelAndView taskAssigneeList(ModelAndView model, HttpServletRequest request) throws IOException {
		
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		
		String taskByAssigneeID=taskMSTService.getAllTaskByUserID(user.getEcategory(), user.getId(),false);
		List<TaskMST> taskMstList =null;
		if(!taskByAssigneeID.isEmpty())
		 taskMstList =taskMSTService.getAllTaskMST(taskByAssigneeID + ":^id", " id desc ");
		String sid = request.getSession().getId();
		model.addObject("from", "assignee");
		model.addObject("taskmstList", taskMstList);
		model.addObject("titleMSG", "Task Assignee List");
		model.setViewName("TaskMstList");
		return model;
	}

	@RequestMapping(value = "/TProjects")
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

	@RequestMapping(value = "/deleteTaskMst")
	public ModelAndView deleteTaskMst(ModelAndView model, HttpServletRequest request) throws IOException {

		int taskMstid = Integer.parseInt(request.getParameter("id"));
		taskMSTService.deleteTaskMST(taskMstid);
		model.setViewName("redirect:/TaskMstList");
		return model;
	}

}
