package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.AnswersEntity;
import com.example.demo.Entity.QustionsEntity;
import com.example.demo.Repository.QustionsRepository;

@CrossOrigin("*")
@RestController
public class Qustionscontroller {
	@Autowired
	private QustionsRepository qustionsrepository;

	
	
	@PostMapping("/add")
	public QustionsEntity addQustions(@RequestParam(name = "qustion") String qustions) {
		QustionsEntity q = new QustionsEntity();

		q.setQustions(qustions);
		q.setDate(new Date());
		q = qustionsrepository.save(q);
		return q;
	}

	@GetMapping("/findOne/{id}")
	public Optional<QustionsEntity> findOne(@PathVariable(name = "id") int id) {
		Optional<QustionsEntity> q = qustionsrepository.findById(id);
		return q;

	}

	@GetMapping("/allQustions")
	public ResponseEntity<?> getAllQustions() {

		List<QustionsEntity> q = qustionsrepository.findAll();
		
		  return new ResponseEntity<List<QustionsEntity>>(q,HttpStatus.OK);
			        

	}

	@GetMapping("/allAnswersByQustionIid/{id}")
	public List<AnswersEntity> findAll(@PathVariable(name = "id") int id) {
		List<AnswersEntity> lis = new ArrayList<>();
		Optional<QustionsEntity> q = qustionsrepository.findById(id);
		if (q.isPresent()) {
			for (AnswersEntity a : q.get().getAnswers()){
				AnswersEntity entity = new AnswersEntity();
				entity.setId(a.getId());
				entity.setDate(a.getDate());
				entity.setAnswer(a.getAnswer());
				lis.add(entity);
			}
			;

		}
		return lis;

	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(name = "id") int id) {
		qustionsrepository.deleteById(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.ACCEPTED);
	}

	@PutMapping("/updatQustions/{id}")
	public QustionsEntity updatQustions(@PathVariable(name = "id") int id) {

		List<QustionsEntity> q = new ArrayList<>();
		for (int i = 0; i < q.size(); i++) {

			QustionsEntity qustionsentity = q.get(i);
			if (i == id) {

				q.set(i, qustionsentity);

				return qustionsentity;
			}
		}
		return null;

	}
	



}
