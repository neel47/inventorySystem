package com.inventory.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
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

import com.inventory.model.Project;
import com.inventory.model.TaskDET;
import com.inventory.model.TaskMST;
import com.inventory.model.User;
import com.inventory.service.ProjectService;
import com.inventory.service.TaskDETService;
import com.inventory.service.TaskMSTService;
import com.inventory.service.UserProjectsService;
import com.inventory.service.UserService;

@Controller
public class TaskDETController {

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

	@RequestMapping(value = "/TaskDETCreation")
	public ModelAndView taskMstCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {

		int taskMSTId = Integer.parseInt(request.getParameter("id"));
		
		TaskMST taskMST=taskMSTService.getTaskMSTById(taskMSTId);

		TaskDET taskdet = new TaskDET();
		taskdet.setTaskmstid(taskMSTId);

		model.addObject("taskMST", taskMST);
		model.addObject("taskdet", taskdet);
		model.setViewName("TaskDETForm");
		return model;
	}

	@RequestMapping(value = "/TaskDETCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("taskdet") TaskDET taskdet,
			BindingResult result, HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in User Controller");
		}

		taskDETService.addTaskDET(taskdet);
		/*
		 * TaskMST taskmst=taskMSTService.getTaskMSTById(taskdet.getTaskmstid());
		 * List<TaskDET> TaskDETs=taskmst.getTaskDetailRecord();
		 * 
		 * TaskDET taskdet1= taskDETService.getTaskDETById(taskdet.getId()); TaskMST
		 * taskmst2 =taskdet1.getTaskMST();
		 */

		model.setViewName("redirect:/TaskMstAssigneeList");
		return model;
	}

	@RequestMapping(value = "/TaskDETList")
	public ModelAndView taskCreatorList(ModelAndView model, HttpServletRequest request) throws IOException {

		User user = (User) request.getSession().getAttribute("loginUserInfo");
		List<TaskMST> taskMstList = null;

		String taskByCreaterID = taskMSTService.getAllTaskByUserID(user.getEcategory(), user.getId(), true);
		if (!taskByCreaterID.isEmpty())
			taskMstList = taskMSTService.getAllTaskMST(taskByCreaterID + ":^id", " id desc ");
		String sid = request.getSession().getId();
		model.addObject("from", "creator");
		model.addObject("taskmstList", taskMstList);
		model.addObject("titleMSG", "Task Creator List");
		model.setViewName("TaskMstList");
		return model;
	}

	@RequestMapping(value = "/TaskDETStatusView")
	public ModelAndView taskStatusView(ModelAndView model, HttpServletRequest request) throws IOException {

		int taskMSTId = Integer.parseInt(request.getParameter("id"));

		List<TaskDET> tDets = taskDETService.getAllTaskDETByMSTID(taskMSTId);
		TaskMST tmst = taskMSTService.getTaskMSTById(taskMSTId);

		int diff = daysBetween(tmst.getStartdate(), tmst.getEnddate());


		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> dataForBarChart = new ArrayList<String>();
         int sizeDET=tDets.size();
         int goalCompletion=0;
         int barChartMoney=0;
         int mstTaskGoal=Integer.parseInt(getNumber(tmst.getTaskgoal()));
		for (int i = 0 ; i < diff; i++) 
		{
			labels.add(addDays(tmst.getStartdate().toString(),i));
			if(i<sizeDET)
			{
				String temp=""+tDets.get(i).getTaskgoalcompletion();
				data.add(temp);
				
				String tempcost=getNumber(tDets.get(i).getTaskgoaldescription());
				dataForBarChart.add(tempcost);
				barChartMoney+=Integer.parseInt(tempcost);
				
				goalCompletion+=tDets.get(i).getTaskgoalcompletion();
			}
			else
				data.add("");
		}

		/*System.out.println(data.toString());
		System.out.println(labels.toString());*/
          
		String labelFormat=labels.toString().replaceAll("\\[", "");
		labelFormat=labelFormat.replaceAll("\\]", "");
		
		String dataFormat=data.toString().replaceAll("\\[", "");
		dataFormat=dataFormat.replaceAll("\\]", "");
		
		String dataForBarChartFormat=dataForBarChart.toString().replaceAll("\\[", "");
		dataForBarChartFormat=dataForBarChartFormat.replaceAll("\\]", "");
		
		String isBarchat="Y";
		if("DEADLINE".equals(tmst.getTaskcategory()))
				isBarchat="N";
				
		model.addObject("labels", labelFormat);
		model.addObject("goalCompletion", goalCompletion);
		model.addObject("data", dataFormat);
		model.addObject("dataForBarChart", dataForBarChartFormat);
		model.addObject("barChartMoney", barChartMoney);
		model.addObject("mstTaskGoal", mstTaskGoal);
		model.addObject("remainingMoney", mstTaskGoal-barChartMoney);
		model.addObject("isBarchat", isBarchat);
	//	model.addObject("titleMSG", "Task Creator List");
		model.setViewName("TaskStatusView");
		return model;
	}

	
	@RequestMapping(value = "/TaskDETViewList")
	public ModelAndView taskStatusSubmittedView(ModelAndView model, HttpServletRequest request) throws IOException {

		int taskMSTId = Integer.parseInt(request.getParameter("id"));

		List<TaskDET> taskDET = taskDETService.getAllTaskDETByMSTID(taskMSTId);

		
		model.addObject("taskDET", taskDET);
		model.setViewName("TaskDETViewList");
		return model;
	}
	
	@RequestMapping(value = "/deleteTaskDet")
	public ModelAndView deleteTaskMst(ModelAndView model, HttpServletRequest request) throws IOException {

		int taskDETId = Integer.parseInt(request.getParameter("id"));
		TaskDET det=taskDETService.getTaskDETById(taskDETId);
		taskDETService.deleteTaskDET(taskDETId);
		model.setViewName("redirect:/TaskDETViewList?id="+det.getTaskmstid());
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
