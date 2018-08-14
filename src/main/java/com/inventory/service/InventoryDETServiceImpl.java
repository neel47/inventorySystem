package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.InventoryDETDAO;
import com.inventory.model.InventoryDET;
import com.inventory.model.TaskDET;

@Service("inventoryDETService")
@Transactional
public class InventoryDETServiceImpl implements InventoryDETService {

	@Autowired
	private InventoryDETDAO inventoryDETDAO;

	@Override
	public void addInventoryDET(InventoryDET inventoryDET) {
		inventoryDETDAO.addInventoryDET(inventoryDET);
		
	}

	@Override
	public List<InventoryDET> getAllInventoryDET(String specs, String orderBy) {
		return inventoryDETDAO.getAllInventoryDET(specs, orderBy);
	}

	@Override
	public void deleteInventoryDET(Integer inventoryDETId) {
		inventoryDETDAO.deleteInventoryDET(inventoryDETId);
		
	}

	@Override
	public InventoryDET getInventoryDETById(int inventoryDETId) {
		return inventoryDETDAO.getInventoryDETById(inventoryDETId);
	}

	@Override
	public InventoryDET updateInventoryDETById(InventoryDET inventoryDETId) {
		return inventoryDETDAO.updateInventoryDETById(inventoryDETId);
	}

	@Override
	public List<InventoryDET> getAllInventoryDETByMSTID(int himId) {
		return inventoryDETDAO.getAllInventoryDETByMSTID(himId);
	}

	
	
	

}
