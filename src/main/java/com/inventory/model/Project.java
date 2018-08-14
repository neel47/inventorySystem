package com.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROJECT")
	@SequenceGenerator(name = "SQ_PROJECT", sequenceName = "SQ_PROJECT", allocationSize = 1)
	private int ID;

	@Column
	private String name;

	@Column
	private String type;

	@Column
	private String location;

	@Column
	private String address;

	@Column
	private String country;

	@Column
	private String province;

	@Column
	private String city;

	@Column
	private String pincode;

	@Column
	private String telephone;

	@Column
	private int managerid;

	@Column
	private int regionalmanagerid;

	@Column
	@Type(type = "yes_no")
	private boolean enabled = true;

	@Column
	@Type(type = "yes_no")
	private boolean active = true;

	@Column
	@Version
	private int version;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public int getRegionalmanagerid() {
		return regionalmanagerid;
	}

	public void setRegionalmanagerid(int regionalmanagerid) {
		this.regionalmanagerid = regionalmanagerid;
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

}
