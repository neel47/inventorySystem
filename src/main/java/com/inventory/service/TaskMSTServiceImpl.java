package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.TaskMSTDAO;
import com.inventory.model.Project;
import com.inventory.model.TaskMST;

@Service("taskMSTService")
@Transactional
public class TaskMSTServiceImpl implements TaskMSTService {

	@Autowired
	private TaskMSTDAO taskMSTDAO;

	
	@Override
	public void addTaskMST(TaskMST taskMST) {
		taskMSTDAO.addTaskMST(taskMST);
		
	}

	@Override
	public List<TaskMST> getAllTaskMST(String specs, String orderBy) {
		return taskMSTDAO.getAllTaskMST(specs, orderBy);
	}

	@Override
	public void deleteTaskMST(Integer taskMSTId) {
		taskMSTDAO.deleteTaskMST(taskMSTId);
		
	}

	@Override
	public TaskMST getTaskMSTById(int taskMSTId) {
		return taskMSTDAO.getTaskMSTById(taskMSTId);
	}

	@Override
	public TaskMST updateTaskMSTById(TaskMST taskMSTId) {
	return	taskMSTDAO.updateTaskMSTById(taskMSTId);
	}

	@Override
	public String getAllTaskByUserID(String category, int himId, boolean creator) {
		// TODO Auto-generated method stub
		return taskMSTDAO.getAllTaskByUserID(category, himId,creator);
	}

}
