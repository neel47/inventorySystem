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

@Entity
@Table(name = "USERPROJECTS")
public class UserProjects implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USERPROJECTS")
	@SequenceGenerator(name = "SQ_USERPROJECTS", sequenceName = "SQ_USERPROJECTS", allocationSize = 1)
	private int id;

	@Column
	private int projectid;

	@Column(unique=true)
	private int userid;

	@Column
	private String category;

	@Column
	private int regionalmanagerid;

	@Column
	private int managerid;

	@Column
	private int supervisorid;

	@Column
	@Version
	private int version;

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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRegionalmanagerid() {
		return regionalmanagerid;
	}

	public void setRegionalmanagerid(int regionalmanagerid) {
		this.regionalmanagerid = regionalmanagerid;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
