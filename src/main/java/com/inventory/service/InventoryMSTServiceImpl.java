package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.InventoryMSTDAO;
import com.inventory.model.InventoryMST;

@Service("inventoryMSTService")
@Transactional
public class InventoryMSTServiceImpl implements InventoryMSTService {

	@Autowired
	private InventoryMSTDAO inventoryMSTDAO;

	@Override
	public void addInventoryMST(InventoryMST inventoryMST) {
		inventoryMSTDAO.addInventoryMST(inventoryMST);
		
	}

	@Override
	public List<InventoryMST> getAllInventoryMST(String specs, String orderBy) {
	return	inventoryMSTDAO.getAllInventoryMST(specs, orderBy);
	}

	@Override
	public void deleteInventoryMST(Integer inventoryMSTId) {
		inventoryMSTDAO.deleteInventoryMST(inventoryMSTId);
		
	}

	@Override
	public InventoryMST getInventoryMSTById(int inventoryMSTId) {
		return inventoryMSTDAO.getInventoryMSTById(inventoryMSTId);
	}

	@Override
	public InventoryMST updateInventoryMSTById(InventoryMST inventoryMSTId) {
	 return	inventoryMSTDAO.updateInventoryMSTById(inventoryMSTId);
	}

	@Override
	public String getAllInventoryByUserID(String category, int himId) {
		return inventoryMSTDAO.getAllInventoryByUserID(category, himId);
	}

	


}
