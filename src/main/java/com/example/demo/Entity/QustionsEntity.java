package com.example.demo.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Qustions")
public class QustionsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qustions_id")
	private int id;

	@Column(name = "qustions_name")
	private String Qustions;

	@Column(name = "Date")
	private Date date;

	@OneToMany(mappedBy = "qustions",fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = false)
	private List<AnswersEntity> answers;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user_qustion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQustions() {
		return Qustions;
	}

	public void setQustions(String qustions) {
		Qustions = qustions;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<AnswersEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswersEntity> answers) {
		this.answers = answers;
	}

	public User getUser_qustion() {
		return user_qustion;
	}

	public void setUser_qustion(User user_qustion) {
		this.user_qustion = user_qustion;
	}

	

	
	
	


}
