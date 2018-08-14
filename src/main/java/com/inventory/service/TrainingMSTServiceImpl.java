package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.TrainingMSTDAO;
import com.inventory.model.TrainingMST;

@Service("trainingMSTService")
@Transactional
public class TrainingMSTServiceImpl implements TrainingMSTService {

	@Autowired
	private TrainingMSTDAO trainingMSTDAO;

	@Override
	public void addTrainingMST(TrainingMST trainingMST) {
		trainingMSTDAO.addTrainingMST(trainingMST);
		
	}

	@Override
	public List<TrainingMST> getAllTrainingMST(String specs, String orderBy) {
		return trainingMSTDAO.getAllTrainingMST(specs, orderBy);
	}

	@Override
	public void deleteTrainingMST(Integer trainingMSTId) {
		trainingMSTDAO.deleteTrainingMST(trainingMSTId);
		
	}

	@Override
	public TrainingMST getTrainingMSTById(int trainingMSTId) {
		return trainingMSTDAO.getTrainingMSTById(trainingMSTId);
	}

	@Override
	public TrainingMST updateTrainingMSTById(TrainingMST trainingMSTId) {
		return trainingMSTDAO.updateTrainingMSTById(trainingMSTId);
	}

	@Override
	public String getAllTrainingMSTByUserID(String category, int himId) {
	return	trainingMSTDAO.getAllTrainingMSTByUserID(category, himId);
	}

	
	

}
