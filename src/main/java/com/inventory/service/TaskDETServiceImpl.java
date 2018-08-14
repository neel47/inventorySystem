package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.TaskDETDAO;
import com.inventory.model.TaskDET;

@Service("taskDETService")
@Transactional
public class TaskDETServiceImpl implements TaskDETService {

	@Autowired
	private TaskDETDAO taskDETDAO;

	@Override
	public void addTaskDET(TaskDET taskDET) {
		taskDETDAO.addTaskDET(taskDET);
	}

	@Override
	public List<TaskDET> getAllTaskDET(String specs, String orderBy) {
		return taskDETDAO.getAllTaskDET(specs, orderBy);
	}

	@Override
	public void deleteTaskDET(Integer taskDETId) {
		taskDETDAO.deleteTaskDET(taskDETId);
		
	}

	@Override
	public TaskDET getTaskDETById(int taskDETId) {
	return	taskDETDAO.getTaskDETById(taskDETId);
	}

	@Override
	public TaskDET updateTaskDETById(TaskDET taskDETId) {
	return	taskDETDAO.updateTaskDETById(taskDETId);
	}

	@Override
	public List<TaskDET> getAllTaskDETByMSTID( int himId) {
		return taskDETDAO.getAllTaskDETByMSTID(himId);
	}

	
	

}
