package com.inventory.dao;

import java.util.List;

import com.inventory.model.TaskDET;
import com.inventory.model.User;

public interface TaskDETDAO {
	public void addTaskDET(TaskDET taskDET);

	public List<TaskDET> getAllTaskDET(String specs, String orderBy);

	public void deleteTaskDET(Integer taskDETId);

	public TaskDET getTaskDETById(int taskDETId);

	public TaskDET updateTaskDETById(TaskDET taskDETId);
	
	public List<TaskDET> getAllTaskDETByMSTID(int himId);


}
