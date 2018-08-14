package com.inventory.dao;

import java.util.List;

import com.inventory.model.InventoryDET;


public interface InventoryDETDAO {
	public void addInventoryDET(InventoryDET inventoryDET);

	public List<InventoryDET> getAllInventoryDET(String specs, String orderBy);

	public void deleteInventoryDET(Integer inventoryDETId);

	public InventoryDET getInventoryDETById(int inventoryDETId);

	public InventoryDET updateInventoryDETById(InventoryDET inventoryDETId);
	
	public List<InventoryDET> getAllInventoryDETByMSTID(int himId);

}
