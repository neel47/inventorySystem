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
@Table(name = "TRAININGMST")
public class TrainingMST implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TRAININGMST")
	@SequenceGenerator(name = "SQ_TRAININGMST", sequenceName = "SQ_TRAININGMST", allocationSize = 1)
	private int id;

	@Column
	private String trainingname;

	@Column
	private String trainingdescription;

	@Column
	private String trainingcategory;

	@Column
	private String traninggoal;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startdate;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date enddate;

	
	@Column
	private int trainingcreatorid;

	@Column
	private String trainingcreatorycategory;


	
	@Column
	@Type(type = "yes_no")
	private boolean enabled = true;

	@Column
	@Type(type = "yes_no")
	private boolean active = true;

	@Column
	@Version
	private int version;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trainingMST")
	private List<TrainingDET> trainingDETRecords = new ArrayList<TrainingDET>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trainingMST")
	private List<TrainingQuestion> trainingQuestionRecords = new ArrayList<TrainingQuestion>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainingname() {
		return trainingname;
	}

	public void setTrainingname(String trainingname) {
		this.trainingname = trainingname;
	}

	public String getTrainingdescription() {
		return trainingdescription;
	}

	public void setTrainingdescription(String trainingdescription) {
		this.trainingdescription = trainingdescription;
	}

	public String getTrainingcategory() {
		return trainingcategory;
	}

	public void setTrainingcategory(String trainingcategory) {
		this.trainingcategory = trainingcategory;
	}

	public String getTraninggoal() {
		return traninggoal;
	}

	public void setTraninggoal(String traninggoal) {
		this.traninggoal = traninggoal;
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

	public int getTrainingcreatorid() {
		return trainingcreatorid;
	}

	public void setTrainingcreatorid(int trainingcreatorid) {
		this.trainingcreatorid = trainingcreatorid;
	}

	public String getTrainingcreatorycategory() {
		return trainingcreatorycategory;
	}

	public void setTrainingcreatorycategory(String trainingcreatorycategory) {
		this.trainingcreatorycategory = trainingcreatorycategory;
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

	public List<TrainingDET> getTrainingDETRecords() {
		return trainingDETRecords;
	}

	public void setTrainingDETRecords(List<TrainingDET> trainingDETRecords) {
		this.trainingDETRecords = trainingDETRecords;
	}

	public List<TrainingQuestion> getTrainingQuestionRecords() {
		return trainingQuestionRecords;
	}

	public void setTrainingQuestionRecords(List<TrainingQuestion> trainingQuestionRecords) {
		this.trainingQuestionRecords = trainingQuestionRecords;
	}
	
	

	

}
