package com.inventory.service;

import java.util.List;

import com.inventory.model.TrainingQuestion;

public interface TrainingQuestionService {
	public void addTrainingQuestion(TrainingQuestion trainingQuestion);

	public List<TrainingQuestion> getAllTrainingQuestion(String specs, String orderBy);

	public void deleteTrainingQuestion(Integer trainingQuestionId);

	public TrainingQuestion getTrainingQuestionById(int trainingQuestionId);

	public TrainingQuestion updateTrainingQuestionById(TrainingQuestion trainingQuestionId);
	
	public List<TrainingQuestion> getAllTrainingQuestionByMSTID(int himId);


}
