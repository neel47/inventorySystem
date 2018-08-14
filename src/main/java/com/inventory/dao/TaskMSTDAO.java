package com.inventory.dao;

import java.util.List;

import com.inventory.model.TaskMST;

public interface TaskMSTDAO {
	public void addTaskMST(TaskMST taskMST);

	public List<TaskMST> getAllTaskMST(String specs, String orderBy);

	public void deleteTaskMST(Integer taskMSTId);

	public TaskMST getTaskMSTById(int taskMSTId);

	public TaskMST updateTaskMSTById(TaskMST taskMSTId);
	
	public String getAllTaskByUserID(String category, int himId, boolean creator);


}
