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
@Table(name = "TASKMST")
public class TaskMST implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TASKMST")
	@SequenceGenerator(name = "SQ_TASKMST", sequenceName = "SQ_TASKMST", allocationSize = 1)
	private int id;

	@Column
	private String taskname;

	@Column
	private String taskdescription;

	@Column
	private String taskcategory;

	@Column
	private String taskgoal;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startdate;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date enddate;

	
	@Column
	private int taskassigneeid;

	@Column
	private String taskassigneecategory;

	@Column
	private int taskcreatorid;

	@Column
	private String taskcreatorcategory;

	
	@Column
	@Type(type = "yes_no")
	private boolean enabled = true;

	@Column
	@Type(type = "yes_no")
	private boolean active = true;

	@Column
	@Version
	private int version;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taskMST")
	private List<TaskDET> taskDetailRecord = new ArrayList<TaskDET>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskdescription() {
		return taskdescription;
	}

	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}

	public String getTaskcategory() {
		return taskcategory;
	}

	public void setTaskcategory(String taskcategory) {
		this.taskcategory = taskcategory;
	}

	public String getTaskgoal() {
		return taskgoal;
	}

	public void setTaskgoal(String taskgoal) {
		this.taskgoal = taskgoal;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getTaskassigneeid() {
		return taskassigneeid;
	}

	public void setTaskassigneeid(int taskassigneeid) {
		this.taskassigneeid = taskassigneeid;
	}

	public String getTaskassigneecategory() {
		return taskassigneecategory;
	}

	public void setTaskassigneecategory(String taskassigneecategory) {
		this.taskassigneecategory = taskassigneecategory;
	}

	public int getTaskcreatorid() {
		return taskcreatorid;
	}

	public void setTaskcreatorid(int taskcreatorid) {
		this.taskcreatorid = taskcreatorid;
	}

	public String getTaskcreatorcategory() {
		return taskcreatorcategory;
	}

	public void setTaskcreatorcategory(String taskcreatorcategory) {
		this.taskcreatorcategory = taskcreatorcategory;
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

	public List<TaskDET> getTaskDetailRecord() {
		return taskDetailRecord;
	}

	public void setTaskDetailRecord(List<TaskDET> taskDetailRecord) {
		this.taskDetailRecord = taskDetailRecord;
	}

}
