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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TRAININGQUESTION")
public class TrainingQuestion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TRAININGQUESTION")
	@SequenceGenerator(name = "SQ_TRAININGQUESTION", sequenceName = "SQ_TRAININGQUESTION", allocationSize = 1)
	private int id;

	@Column
	private int trainingmstid;

	@Column
	private String question;

	@Column
	private String option1;

	@Column
	private String option2;
	
	@Column
	private String option3;
	
	
	@Column
	private String option4;
	
	@Column
	private String option5;
	
	@Column
	private String option6;
	
	@Column
	private String option7;
	
	@Column
	private String option8;
	
	@Column
	private String option9;
	
	@Column
	private String option10;
	
	@Column
	private int totaloption;
	
	@Column
	private int rightoption;

	@Transient
	private String answerOption;

	
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


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getOption1() {
		return option1;
	}


	public void setOption1(String option1) {
		this.option1 = option1;
	}


	public String getOption2() {
		return option2;
	}


	public void setOption2(String option2) {
		this.option2 = option2;
	}


	public String getOption3() {
		return option3;
	}


	public void setOption3(String option3) {
		this.option3 = option3;
	}


	public String getOption4() {
		return option4;
	}


	public void setOption4(String option4) {
		this.option4 = option4;
	}


	public String getOption5() {
		return option5;
	}


	public void setOption5(String option5) {
		this.option5 = option5;
	}


	public String getOption6() {
		return option6;
	}


	public void setOption6(String option6) {
		this.option6 = option6;
	}


	public String getOption7() {
		return option7;
	}


	public void setOption7(String option7) {
		this.option7 = option7;
	}


	public String getOption8() {
		return option8;
	}


	public void setOption8(String option8) {
		this.option8 = option8;
	}


	public String getOption9() {
		return option9;
	}


	public void setOption9(String option9) {
		this.option9 = option9;
	}


	public String getOption10() {
		return option10;
	}


	public void setOption10(String option10) {
		this.option10 = option10;
	}


	public int getTotaloption() {
		return totaloption;
	}


	public void setTotaloption(int totaloption) {
		this.totaloption = totaloption;
	}


	public int getRightoption() {
		return rightoption;
	}


	public void setRightoption(int rightoption) {
		this.rightoption = rightoption;
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


	public String getAnswerOption() {
		return answerOption;
	}


	public void setAnswerOption(String answerOption) {
		this.answerOption = answerOption;
	}


	

	
	

}
