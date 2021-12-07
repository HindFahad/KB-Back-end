package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@Column(name = "first_name")
	private String Firstname;

	@Column(name = "last_name")
	private String Lasttname;

	@Column(name = "user_name")
	private String username;
	@Column(name = "password")
	private String  password;

	@Column(name = "email")
	private String email;
	

	@OneToMany(mappedBy = "user_answer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	private List<AnswersEntity> answers;
	
	@OneToMany(mappedBy = "user_qustion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	private List<QustionsEntity> qustions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLasttname() {
		return Lasttname;
	}

	public void setLasttname(String lasttname) {
		Lasttname = lasttname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AnswersEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswersEntity> answers) {
		this.answers = answers;
	}

	public List<QustionsEntity> getQustions() {
		return qustions;
	}

	public void setQustions(List<QustionsEntity> qustions) {
		this.qustions = qustions;
	}



	
}
