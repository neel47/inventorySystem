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
import com.inventory.model.TrainingMST;
import com.inventory.model.User;
import com.inventory.service.ProjectService;
import com.inventory.service.TaskMSTService;
import com.inventory.service.TrainingDETService;
import com.inventory.service.TrainingMSTService;
import com.inventory.service.UserProjectsService;
import com.inventory.service.UserService;

@Controller
public class TrainingMSTController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserProjectsService userProjectsService;
	
	@Autowired
	private TaskMSTService taskMSTService;
	
	@Autowired
	private TrainingMSTService trainingMSTService;
	
	@Autowired
	private TrainingDETService trainingDETService;

	@RequestMapping(value = "/TrainingMSTCreation")
	public ModelAndView trainingMstCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {

		TrainingMST trainingmst=new TrainingMST();
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		
		trainingmst.setTrainingcreatorid(user.getId());
		trainingmst.setTrainingcreatorycategory(user.getEcategory());
		
		model.addObject("trainingmst", trainingmst);
		model.setViewName("TrainingMSTForm");
		return model;
	}

	@RequestMapping(value = "/TrainingMSTCreationSave")
	public ModelAndView save(ModelAndView model,@Valid @ModelAttribute("trainingmst") TrainingMST trainingmst, BindingResult result, HttpServletRequest request) throws IOException {
		
		if (result.hasErrors()) {
			System.out.println("Error in User Controller");
		}

		trainingMSTService.addTrainingMST(trainingmst);

		model.setViewName("redirect:/TrainingMstList");
		return model;
	}

	@RequestMapping(value = "/TrainingMstList")
	public ModelAndView trainingCreatorList(ModelAndView model, HttpServletRequest request) throws IOException {
		
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		List<TrainingMST> trainingMSTList=null;
		
		if("SUPERVISOR".equals(user.getEcategory()))
		trainingMSTList=trainingMSTService.getAllTrainingMST(user.getId()+":trainingcreatorid", " id desc ");
		else
		{
			String mstids=trainingDETService.mstIDfromUserId(user.getId());
			if(!mstids.isEmpty())
	    trainingMSTList=trainingMSTService.getAllTrainingMST(mstids+":^id", " id desc ");
		}
		
		
		
		model.addObject("trainingMSTList", trainingMSTList);
		model.addObject("titleMSG", "Training List");
		model.setViewName("TrainingMSTList");
		return model;
	}
	
	@RequestMapping(value = "/editTrainingMst")
	public ModelAndView trainingAssigneeList(ModelAndView model, HttpServletRequest request) throws IOException {
		
		int trainingMSTId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		
		TrainingMST trainingmst=trainingMSTService.getTrainingMSTById(trainingMSTId);
		
		model.addObject("trainingmst", trainingmst);
		model.setViewName("TrainingMSTForm");
		return model;
	}

	@RequestMapping(value = "/Training1Projects")
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

	@RequestMapping(value = "/deleteTrainingMst")
	public ModelAndView deleteTrainingMst(ModelAndView model, HttpServletRequest request) throws IOException {

		int trainingMSTId = Integer.parseInt(request.getParameter("id"));
		
		trainingMSTService.deleteTrainingMST(trainingMSTId);
		model.setViewName("redirect:/TrainingMstList");
		return model;
	}

}
