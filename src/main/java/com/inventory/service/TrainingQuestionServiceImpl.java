package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.TrainingQuestionDAO;
import com.inventory.model.TrainingQuestion;

@Service("trainingQuestionService")
@Transactional
public class TrainingQuestionServiceImpl implements TrainingQuestionService {

	@Autowired
	private TrainingQuestionDAO trainingQuestionDAO;

	@Override
	public void addTrainingQuestion(TrainingQuestion trainingQuestion) {
		trainingQuestionDAO.addTrainingQuestion(trainingQuestion);
		
	}

	@Override
	public List<TrainingQuestion> getAllTrainingQuestion(String specs, String orderBy) {
		return trainingQuestionDAO.getAllTrainingQuestion(specs, orderBy);
	}

	@Override
	public void deleteTrainingQuestion(Integer trainingQuestionId) {
		trainingQuestionDAO.deleteTrainingQuestion(trainingQuestionId);
		
	}

	@Override
	public TrainingQuestion getTrainingQuestionById(int trainingQuestionId) {
		return trainingQuestionDAO.getTrainingQuestionById(trainingQuestionId);
	}

	@Override
	public TrainingQuestion updateTrainingQuestionById(TrainingQuestion trainingQuestionId) {
		return trainingQuestionDAO.updateTrainingQuestionById(trainingQuestionId);
	}

	@Override
	public List<TrainingQuestion> getAllTrainingQuestionByMSTID(int himId) {
		return trainingQuestionDAO.getAllTrainingQuestionByMSTID(himId);
	}

	
	

}
