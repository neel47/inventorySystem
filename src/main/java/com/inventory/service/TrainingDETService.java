package com.inventory.service;

import java.util.List;

import com.inventory.model.TrainingDET;

public interface TrainingDETService {
	public void addTrainingDET(TrainingDET trainingDET);

	public List<TrainingDET> getAllTrainingDET(String specs, String orderBy);

	public void deleteTrainingDET(Integer trainingDETId);

	public TrainingDET getTrainingDETById(int trainingDETId);

	public TrainingDET updateTrainingDETById(TrainingDET trainingDETId);
	
	public List<TrainingDET> getAllTrainingDETByMSTID(int himId);
	
	public String mstIDfromUserId(int himId);
	

}
