package com.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "INVENTORYDETAIL")
public class InventoryDET implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INVENTORYDETAIL")
	@SequenceGenerator(name = "SQ_INVENTORYDETAIL", sequenceName = "SQ_INVENTORYDETAIL", allocationSize = 1)
	private int id;

	@Column
	private int inventorymstid;

	

	@Column
	private String inventorysubcategory;
	
	@Column
	private String brand;

	@Column
	private double quantity;

	@Column
	private double price;
	
	@Column
	private double totalprice;
	
	@Column
	private String additionalinfo;
	
	@Column
	@Type(type = "yes_no")
	private boolean enabled = true;

	@Column
	@Type(type = "yes_no")
	private boolean active = true;
	

	@Column
	@Version
	private int version;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="inventorymstid" , insertable=false , updatable=false )
	private InventoryMST inventoryMST;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getInventorymstid() {
		return inventorymstid;
	}


	public void setInventorymstid(int inventorymstid) {
		this.inventorymstid = inventorymstid;
	}


	public String getInventorysubcategory() {
		return inventorysubcategory;
	}


	public void setInventorysubcategory(String inventorysubcategory) {
		this.inventorysubcategory = inventorysubcategory;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	

	public double getQuantity() {
		return quantity;
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}


	public String getAdditionalinfo() {
		return additionalinfo;
	}


	public void setAdditionalinfo(String additionalinfo) {
		this.additionalinfo = additionalinfo;
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


	public InventoryMST getInventoryMST() {
		return inventoryMST;
	}


	public void setInventoryMST(InventoryMST inventoryMST) {
		this.inventoryMST = inventoryMST;
	}


}
