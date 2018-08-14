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

import com.inventory.model.InventoryDET;
import com.inventory.model.InventoryMST;
import com.inventory.model.Project;
import com.inventory.model.User;
import com.inventory.service.InventoryDETService;
import com.inventory.service.InventoryMSTService;
import com.inventory.service.ProjectService;
import com.inventory.service.UserProjectsService;
import com.inventory.service.UserService;

@Controller
public class InventoryDETController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserProjectsService userProjectsService;


	@Autowired
	private InventoryMSTService inventoryMSTService;
	
	@Autowired
	private InventoryDETService inventoryDETService;

	@RequestMapping(value = "/InventoryDETCreation")
	public ModelAndView inventoryDetCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {

		int inventoryMSTId = Integer.parseInt(request.getParameter("id"));

		InventoryDET inventoryDet = new InventoryDET();
		inventoryDet.setInventorymstid(inventoryMSTId);
		
		
		model.addObject("inventoryDet", inventoryDet);
		model.setViewName("InventoryDetForm");
		return model;
	}

	@RequestMapping(value = "/InventoryDETCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("inventoryDet") InventoryDET inventoryDet,
			BindingResult result, HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in User Controller");
		}

		inventoryDETService.addInventoryDET(inventoryDet);

		model.setViewName("redirect:/InventoryDetList?id="+inventoryDet.getInventorymstid());
		return model;
	}

	@RequestMapping(value = "/InventoryDetList")
	public ModelAndView inventoryCreatorList(ModelAndView model, HttpServletRequest request) throws IOException {

		List<InventoryDET> inventdets=null;
		
		int inventoryMSTId = Integer.parseInt(request.getParameter("id"));

		inventdets= inventoryDETService.getAllInventoryDET(inventoryMSTId+":inventorymstid"," id desc ");
		
		String sid = request.getSession().getId();
		model.addObject("titleMSG", "Sub-Category List");
		model.addObject("inventdets", inventdets);
		model.setViewName("InventoryDetList");
		return model;
	}

	@RequestMapping(value = "/InventoryEditDet")
	public ModelAndView inventoryAssigneeList(ModelAndView model, HttpServletRequest request) throws IOException {

		int inventoryDETId = Integer.parseInt(request.getParameter("id"));

		InventoryDET inventoryDet = inventoryDETService.getInventoryDETById(inventoryDETId);

		model.addObject("inventoryDet", inventoryDet);
		model.setViewName("InventoryDetForm");
		return model;
	}

	

	@RequestMapping(value = "/InventoryDeleteDet")
	public ModelAndView deleteInventoryDet(ModelAndView model, HttpServletRequest request) throws IOException {

		int inventoryDETId = Integer.parseInt(request.getParameter("id"));
		InventoryDET inventDet=inventoryDETService.getInventoryDETById(inventoryDETId);
		inventoryDETService.deleteInventoryDET(inventoryDETId);
		model.setViewName("redirect:/InventoryDetList?id="+inventDet.getInventorymstid());
		return model;
	}

}
