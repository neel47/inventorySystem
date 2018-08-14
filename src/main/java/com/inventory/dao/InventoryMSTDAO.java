package com.inventory.dao;

import java.util.List;

import com.inventory.model.InventoryMST;

public interface InventoryMSTDAO {
	public void addInventoryMST(InventoryMST inventoryMST);

	public List<InventoryMST> getAllInventoryMST(String specs, String orderBy);

	public void deleteInventoryMST(Integer inventoryMSTId);

	public InventoryMST getInventoryMSTById(int inventoryMSTId);

	public InventoryMST updateInventoryMSTById(InventoryMST inventoryMSTId);
	
	public String getAllInventoryByUserID(String category, int himId);


}
