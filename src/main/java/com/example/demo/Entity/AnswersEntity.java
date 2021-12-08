package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Answers")
public class AnswersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Answer_id")
	private int id;

	@Column(name = "Answer")
	private String Answer;

	@Column(name = "Date")
	private Date date;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "qustions_id")
	private QustionsEntity  qustions;

	// User Relation //

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user_answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public QustionsEntity getQustions() {
		return qustions;
	}

	public void setQustions(QustionsEntity qustions) {
		this.qustions = qustions;
	}

	public UserEntity getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(UserEntity user_answer) {
		this.user_answer = user_answer;
	}



	

	
}
