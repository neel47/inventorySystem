package com.inventory.dao;

import java.util.List;

import com.inventory.model.TrainingMST;


public interface TrainingMSTDAO {
	public void addTrainingMST(TrainingMST trainingMST);

	public List<TrainingMST> getAllTrainingMST(String specs, String orderBy);

	public void deleteTrainingMST(Integer trainingMSTId);

	public TrainingMST getTrainingMSTById(int trainingMSTId);

	public TrainingMST updateTrainingMSTById(TrainingMST trainingMSTId);
	
	public String getAllTrainingMSTByUserID(String category, int himId);


}
