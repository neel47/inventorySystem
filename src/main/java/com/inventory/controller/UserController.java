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

import com.inventory.model.User;
import com.inventory.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/UserCreation")
	public ModelAndView userCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		User user = new User();
		String sid = request.getSession().getId();
		model.addObject("user", user);
		model.setViewName("UserForm");
		return model;
	}

	@RequestMapping(value = "/UserCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in User Controller");
		}
		if (null != user.getEcategory() && user.getEcategory().equals("ADMIN"))
			user.setIsadmin(true);
		userService.addUser(user);
		model.setViewName("redirect:/UserList");
		return model;
	}

	@RequestMapping(value = "/UserList")
	public ModelAndView UserList(ModelAndView model, HttpServletRequest request) throws IOException {

		StringBuilder specs = new StringBuilder();
		if (null != request.getParameter("category")) {
			String category = (String) request.getParameter("category");
			specs.append(category);
			specs.append(":ecategory,");
		}

		List<User> userList = userService.getAllUsers(specs.toString(), " id desc ");
		String sid = request.getSession().getId();
		model.addObject("userList", userList);
		model.setViewName("UserList");
		return model;
	}

	@RequestMapping(value = "/editUser")
	public ModelAndView editUser(ModelAndView model, HttpServletRequest request) throws IOException {

		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(userId);
		String sid = request.getSession().getId();
		model.addObject("user", user);
		model.setViewName("UserForm");
		return model;
	}

	@RequestMapping(value = "/deleteUser")
	public ModelAndView deleteUser(ModelAndView model, HttpServletRequest request) throws IOException {

		int userId = Integer.parseInt(request.getParameter("id"));
		userService.deleteUser(userId);
		;
		model.setViewName("redirect:/UserList");
		return model;
	}

}
