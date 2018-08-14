package com.inventory.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "INVENTORYMST")
public class InventoryMST implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INVENTORYMST")
	@SequenceGenerator(name = "SQ_INVENTORYMST", sequenceName = "SQ_INVENTORYMST", allocationSize = 1)
	private int id;

	@Column
	private int projectid;

	@Column
	private int managerid;

	@Column
	private int supervisorid;

	@Column
	private String inventorycategory;

	@Column
	@Type(type = "yes_no")
	private boolean enabled = true;

	@Column
	@Type(type = "yes_no")
	private boolean active = true;

	@Column
	@Version
	private int version;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryMST")
	private List<InventoryDET> inventoryDETRecords = new ArrayList<InventoryDET>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public int getSupervisorid() {
		return supervisorid;
	}

	public void setSupervisorid(int supervisorid) {
		this.supervisorid = supervisorid;
	}

	public String getInventorycategory() {
		return inventorycategory;
	}

	public void setInventorycategory(String inventorycategory) {
		this.inventorycategory = inventorycategory;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<InventoryDET> getInventoryDETRecords() {
		return inventoryDETRecords;
	}

	public void setInventoryDETRecords(List<InventoryDET> inventoryDETRecords) {
		this.inventoryDETRecords = inventoryDETRecords;
	}
	
	

}
