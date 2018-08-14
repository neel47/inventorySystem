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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TASKDETAIL")
public class TaskDET implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TASKDETAIL")
	@SequenceGenerator(name = "SQ_TASKDETAIL", sequenceName = "SQ_TASKDETAIL", allocationSize = 1)
	private int id;

	@Column
	private int taskmstid;

	

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date taskdate;
	
	@Column
	private String taskeoddescription;

	@Column
	private String taskgoaldescription;

	@Column
	private double taskgoalcompletion;
	

	@Column
	@Version
	private int version;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="taskmstid" , insertable=false , updatable=false )
	private TaskMST taskMST;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTaskmstid() {
		return taskmstid;
	}


	public void setTaskmstid(int taskmstid) {
		this.taskmstid = taskmstid;
	}


	public Date getTaskdate() {
		return taskdate;
	}


	public void setTaskdate(Date taskdate) {
		this.taskdate = taskdate;
	}


	public String getTaskeoddescription() {
		return taskeoddescription;
	}


	public void setTaskeoddescription(String taskeoddescription) {
		this.taskeoddescription = taskeoddescription;
	}


	public String getTaskgoaldescription() {
		return taskgoaldescription;
	}


	public void setTaskgoaldescription(String taskgoaldescription) {
		this.taskgoaldescription = taskgoaldescription;
	}


	public double getTaskgoalcompletion() {
		return taskgoalcompletion;
	}


	public void setTaskgoalcompletion(double taskgoalcompletion) {
		this.taskgoalcompletion = taskgoalcompletion;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public TaskMST getTaskMST() {
		return taskMST;
	}


	public void setTaskMST(TaskMST taskMST) {
		this.taskMST = taskMST;
	}

	

}
