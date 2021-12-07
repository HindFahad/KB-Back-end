package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.AnswersEntity;
import com.example.demo.Entity.QustionsEntity;
import com.example.demo.Repository.AnswersRepository;
@CrossOrigin("*")
@RestController
public class Answerscontroller {
	@Autowired
	AnswersRepository answersrepository;

	@PostMapping("/Answers")
	public AnswersEntity addanswers(@RequestParam(name = "Answers") String Answers ,@RequestBody QustionsEntity Qustions ) {
		AnswersEntity a = new AnswersEntity();
		a.setAnswer(Answers);
		a.setDate(new Date());
		a.setQustions(Qustions);
		a = answersrepository.save(a);
		return a;
	}

	

}
