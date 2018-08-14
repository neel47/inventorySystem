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

import com.inventory.model.InventoryMST;
import com.inventory.model.Project;
import com.inventory.model.User;
import com.inventory.service.InventoryMSTService;
import com.inventory.service.ProjectService;
import com.inventory.service.UserProjectsService;
import com.inventory.service.UserService;

@Controller
public class InventoryMSTController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserProjectsService userProjectsService;


	@Autowired
	private InventoryMSTService inventoryMSTService;

	@RequestMapping(value = "/InventoryMSTCreation")
	public ModelAndView inventoryMstCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {

		InventoryMST inventoryMst = new InventoryMST();
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		List<User> users = null;
		Project projectInfoOfUser;

		if ("PROJECTMANAGER".equals(user.getEcategory())) {

			String idOfUserUnder = userProjectsService.userIdUnderHimById("PROJECTMANAGER", user.getId());
			if (!idOfUserUnder.isEmpty())
				users = userService.getAllUsers("SUPERVISOR:ecategory&" + idOfUserUnder + ":^id", " id desc ");

			projectInfoOfUser = projectInfoOfUser = projectService
					.getAllProjects(user.getId() + ":managerid", " id desc ").get(0);

			inventoryMst.setProjectid(projectInfoOfUser.getID());
			inventoryMst.setManagerid(user.getId());
		}

		model.addObject("users", users);
		model.addObject("inventoryMst", inventoryMst);
		model.setViewName("InventoryMstForm");
		return model;
	}

	@RequestMapping(value = "/InventoryMSTCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("inventoryMst") InventoryMST inventoryMst,
			BindingResult result, HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in User Controller");
		}

		inventoryMSTService.addInventoryMST(inventoryMst);

		model.setViewName("redirect:/InventoryMstList");
		return model;
	}

	@RequestMapping(value = "/InventoryMstList")
	public ModelAndView inventoryCreatorList(ModelAndView model, HttpServletRequest request) throws IOException {

		User user = (User) request.getSession().getAttribute("loginUserInfo");
		List<InventoryMST> inventMSTs = null;

		if(!"EMPLOYEE".equals(user.getEcategory()))
		{
		String inventoryByManagerID = inventoryMSTService.getAllInventoryByUserID(user.getEcategory(), user.getId());
		if (!inventoryByManagerID.isEmpty())
			inventMSTs = inventoryMSTService.getAllInventoryMST(inventoryByManagerID + ":^id", " id desc ");
		}
		else
		{////here
			String supervisorId=userProjectsService.supervisorIdFromUserId(user.getEcategory(), user.getId());
			String inventoryByManagerID = inventoryMSTService.getAllInventoryByUserID(user.getEcategory(), Integer.parseInt(supervisorId));
			if (!inventoryByManagerID.isEmpty())
				inventMSTs = inventoryMSTService.getAllInventoryMST(inventoryByManagerID + ":^id", " id desc ");
		}
		
		
		String sid = request.getSession().getId();
		model.addObject("titleMSG", "Category List");
		model.addObject("inventMSTs", inventMSTs);
		model.setViewName("InventoryMstList");
		return model;
	}

	@RequestMapping(value = "/InventoryEditMst")
	public ModelAndView inventoryAssigneeList(ModelAndView model, HttpServletRequest request) throws IOException {

		User user = (User) request.getSession().getAttribute("loginUserInfo");
		int inventoryMSTId = Integer.parseInt(request.getParameter("id"));

		InventoryMST inventoryMst = inventoryMSTService.getInventoryMSTById(inventoryMSTId);
		List<User> users = null;
		Project projectInfoOfUser;

		if ("PROJECTMANAGER".equals(user.getEcategory())) {

			String idOfUserUnder = userProjectsService.userIdUnderHimById("PROJECTMANAGER", user.getId());
			if (!idOfUserUnder.isEmpty())
				users = userService.getAllUsers("SUPERVISOR:ecategory&" + idOfUserUnder + ":^id", " id desc ");

			/*
			 * projectInfoOfUser = projectInfoOfUser = projectService
			 * .getAllProjects(user.getId() + ":managerid", " id desc ").get(0);
			 */
			//inventoryMst.setProjectid(projectInfoOfUser.getID());
			//inventoryMst.setManagerid(user.getId());
		}

		model.addObject("users", users);
		model.addObject("inventoryMst", inventoryMst);
		model.setViewName("InventoryMstForm");
		return model;
	}

	

	@RequestMapping(value = "/InventoryDeleteMst")
	public ModelAndView deleteInventoryMst(ModelAndView model, HttpServletRequest request) throws IOException {

		int inventoryMSTId = Integer.parseInt(request.getParameter("id"));
		inventoryMSTService.deleteInventoryMST(inventoryMSTId);
		model.setViewName("redirect:/InventoryMstList");
		return model;
	}

}
