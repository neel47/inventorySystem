package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.TrainingDETDAO;
import com.inventory.model.InventoryDET;
import com.inventory.model.TrainingDET;

@Service("trainingDETService")
@Transactional
public class TrainingDETServiceImpl implements TrainingDETService {

	@Autowired
	private TrainingDETDAO trainingDETDAO;

	@Override
	public void addTrainingDET(TrainingDET trainingDET) {
		trainingDETDAO.addTrainingDET(trainingDET);
		
	}

	@Override
	public List<TrainingDET> getAllTrainingDET(String specs, String orderBy) {
		return trainingDETDAO.getAllTrainingDET(specs, orderBy);
	}

	@Override
	public void deleteTrainingDET(Integer trainingDETId) {
		trainingDETDAO.deleteTrainingDET(trainingDETId);
		
	}

	@Override
	public TrainingDET getTrainingDETById(int trainingDETId) {
		return trainingDETDAO.getTrainingDETById(trainingDETId);
	}

	@Override
	public TrainingDET updateTrainingDETById(TrainingDET trainingDETId) {
		return trainingDETDAO.updateTrainingDETById(trainingDETId);
	}

	@Override
	public List<TrainingDET> getAllTrainingDETByMSTID(int himId) {
		return trainingDETDAO.getAllTrainingDETByMSTID(himId);
	}

	@Override
	public String mstIDfromUserId(int himId) {
		return trainingDETDAO.mstIDfromUserId(himId);
	}

	
	

}
