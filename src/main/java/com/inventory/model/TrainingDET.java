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

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TRAINNINGDETAIL")
public class TrainingDET implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TRAINNINGDETAIL")
	@SequenceGenerator(name = "SQ_TRAINNINGDETAIL", sequenceName = "SQ_TRAINNINGDETAIL", allocationSize = 1)
	private int id;

	@Column
	private int trainingmstid;

	@Column
	private int trainingassigneeid;
	
	@Column
	private String trainingassigneecategory;


	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datetaken;
	
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date expirydate;
	
	@Column
	private int marksobtained;

	@Column
	private String testresult="Not Taken";

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
	@JoinColumn(name="trainingmstid" , insertable=false , updatable=false )
	private TrainingMST trainingMST;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTrainingmstid() {
		return trainingmstid;
	}


	public void setTrainingmstid(int trainingmstid) {
		this.trainingmstid = trainingmstid;
	}


	public int getTrainingassigneeid() {
		return trainingassigneeid;
	}


	public void setTrainingassigneeid(int trainingassigneeid) {
		this.trainingassigneeid = trainingassigneeid;
	}


	public String getTrainingassigneecategory() {
		return trainingassigneecategory;
	}


	public void setTrainingassigneecategory(String trainingassigneecategory) {
		this.trainingassigneecategory = trainingassigneecategory;
	}


	public Date getDatetaken() {
		return datetaken;
	}


	public void setDatetaken(Date datetaken) {
		this.datetaken = datetaken;
	}


	public Date getExpirydate() {
		return expirydate;
	}


	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}


	public int getMarksobtained() {
		return marksobtained;
	}


	public void setMarksobtained(int marksobtained) {
		this.marksobtained = marksobtained;
	}


	public String getTestresult() {
		return testresult;
	}


	public void setTestresult(String testresult) {
		this.testresult = testresult;
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


	public TrainingMST getTrainingMST() {
		return trainingMST;
	}


	public void setTrainingMST(TrainingMST trainingMST) {
		this.trainingMST = trainingMST;
	}

	
	

	

}
