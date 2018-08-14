package com.inventory.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inventory.model.TrainingDET;
import com.inventory.model.TrainingMST;
import com.inventory.model.TrainingQuestion;
import com.inventory.model.User;
import com.inventory.service.ProjectService;
import com.inventory.service.TaskDETService;
import com.inventory.service.TaskMSTService;
import com.inventory.service.TrainingDETService;
import com.inventory.service.TrainingMSTService;
import com.inventory.service.TrainingQuestionService;
import com.inventory.service.UserProjectsService;
import com.inventory.service.UserService;

@Controller
public class TrainingQuestionController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserProjectsService userProjectsService;

	@Autowired
	private TaskMSTService taskMSTService;

	@Autowired
	private TaskDETService taskDETService;
	
	@Autowired
	private TrainingMSTService trainingMSTService;
	
	@Autowired
	private TrainingQuestionService trainingQuestionService;
	
	@Autowired
	private TrainingDETService trainingDETService;

	@RequestMapping(value = "/TrainingQuestionCreation")
	public ModelAndView taskMstCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {

		int trainingMSTId = Integer.parseInt(request.getParameter("id"));

		TrainingQuestion trainingQuestion = new TrainingQuestion();
		trainingQuestion.setTrainingmstid(trainingMSTId);
		
		

		model.addObject("trainingQuestion", trainingQuestion);
		model.setViewName("TrainingQuestionForm");
		return model;
	}

	@RequestMapping(value = "/TrainingQuestionCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("trainingQuestion") TrainingQuestion trainingQuestion,
			BindingResult result, HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in User Controller");
		}

		trainingQuestionService.addTrainingQuestion(trainingQuestion);
		

		model.setViewName("redirect:/TrainingMstList");
		return model;
	}

	@RequestMapping(value = "/TrainingQuestionList")
	public ModelAndView taskCreatorList(ModelAndView model, HttpServletRequest request) throws IOException {

		int trainingMSTId = Integer.parseInt(request.getParameter("id"));
		
		List<TrainingQuestion> trainingQuestionList = null;
		trainingQuestionList=trainingQuestionService.getAllTrainingQuestion(trainingMSTId+":trainingmstid", " id desc ");
		
		
		model.addObject("trainingQuestionList", trainingQuestionList);
		model.addObject("titleMSG", " List");
		model.setViewName("TrainingQuestionList");
		return model;
	}

	@RequestMapping(value = "/TrainingQuestionTest")
	public ModelAndView taskStatusView(ModelAndView model, HttpServletRequest request) throws IOException {

		int trainingMSTId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("loginUserInfo");

		List<TrainingQuestion> trainingQuestionList = null;
		///List<TrainingDET> trainingDETList = null;
		trainingQuestionList=trainingQuestionService.getAllTrainingQuestionByMSTID(trainingMSTId);
		
		TrainingMST trainingMST=trainingMSTService.getTrainingMSTById(trainingMSTId);
		
		//trainingDETList = trainingDETService.getAllTrainingDET(trainingMSTId+":trainingmstid&"+user.getId()+":trainingassigneeid", " id desc ");
		
		trainingMST.setTrainingQuestionRecords(trainingQuestionList);
		///trainingMST.setTrainingDETRecords(trainingDETList);
		
		model.addObject("counterQuestionList",trainingQuestionList.size());
		model.addObject("trainingMST",trainingMST);
		model.addObject("trainingQuestionList",trainingQuestionList);
		model.addObject("titleMSG", "Task Creator List");
		model.setViewName("TrainingQuestionTest");
		return model;
	}
	
	@RequestMapping(value = "/TrainingQuestionTestSave")
	public ModelAndView trainingQuestionTestSave(ModelAndView model, @Valid @ModelAttribute("trainingMST") TrainingMST trainingMST,BindingResult result, HttpServletRequest request) throws IOException {

		

		if (result.hasErrors()) {
			System.out.println("Error in Trainig Question Controller");
		}
		
		User user = (User) request.getSession().getAttribute("loginUserInfo");
		List<TrainingQuestion> trainingQuestionList =trainingMST.getTrainingQuestionRecords();
		TrainingDET trainingDET=trainingDETService.getAllTrainingDET(trainingMST.getId()+":trainingmstid&"+user.getId()+":trainingassigneeid", " id desc ").get(0);
		
		int testCounter=0;
		
		for(TrainingQuestion fromUI :trainingQuestionList)
		{
			if(!fromUI.getAnswerOption().isEmpty() && Integer.parseInt(fromUI.getAnswerOption())==fromUI.getRightoption())
				testCounter++;
		}
		String trainingGoal=getNumber(trainingMST.getTraninggoal());
		
		if(testCounter>= Integer.parseInt(trainingGoal))
		{
			trainingDET.setTestresult("Pass");
		}
		else
		{
			trainingDET.setTestresult("Fail");
		}
		trainingDET.setDatetaken(new Date());
		trainingDET.setMarksobtained(testCounter);
		trainingDET.setActive(false);
		
		trainingDETService.addTrainingDET(trainingDET);
		
		model.setViewName("redirect:/TrainingMstList");
		return model;
	}

	
	@RequestMapping(value = "/editTrainingQuestion")
	public ModelAndView taskStatusSubmittedView(ModelAndView model, HttpServletRequest request) throws IOException {

		int trainingQuestionId = Integer.parseInt(request.getParameter("id"));

		
		TrainingQuestion trainingQuestion = trainingQuestionService.getTrainingQuestionById(trainingQuestionId);
		
		model.addObject("mode", "EDIT");
		model.addObject("trainingQuestion", trainingQuestion);
		model.setViewName("TrainingQuestionForm");
		return model;
	}
	
	@RequestMapping(value = "/deleteTrainingQuestion")
	public ModelAndView deleteTaskMst(ModelAndView model, HttpServletRequest request) throws IOException {

		int trainingQuestionId = Integer.parseInt(request.getParameter("id"));
		TrainingQuestion trainingQuestion=trainingQuestionService.getTrainingQuestionById(trainingQuestionId);
		
		trainingQuestionService.deleteTrainingQuestion(trainingQuestionId);
		model.setViewName("redirect:/TrainingQuestionList?id="+trainingQuestion.getTrainingmstid());
		return model;
	}

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	 public String addDays(String date, long toAdd) {
		 LocalDate a =LocalDate.parse(date);
		 if(toAdd>0)
		 a = a.plusDays(toAdd);
		return a.getMonth().getDisplayName(TextStyle.SHORT, Locale.UK) + " " + a.getDayOfMonth();
	}
	 
	 public  String getNumber(String alphaNumeric)
	 {
		String regexDigit="\\d+";
		Matcher regex= Pattern.compile(regexDigit).matcher(alphaNumeric);
		while (regex.find()) {
			return  regex.group();
		}
		 return "0";
	 }

}
