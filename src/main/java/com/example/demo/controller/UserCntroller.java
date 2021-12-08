package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.AnswersEntity;
import com.example.demo.Entity.QustionsEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.QustionsRepository;
import com.example.demo.Repository.UserRepository;

@RestController
@CrossOrigin
public class UserCntroller {
	@Autowired
	UserRepository userRepository;
	QustionsRepository qustionsRepository;

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(

			@RequestParam String Firstname, @RequestParam String Lasttname,
			@RequestParam String password, @RequestParam String email) throws Exception {

		List<UserEntity> CheckUser = userRepository.findByEmail(email);

		if (CheckUser == null || CheckUser.size()==0) {

			UserEntity user = new UserEntity();
			user.setFirstname(Firstname);
			user.setLasttname(Lasttname);

			user.setEmail(email);
			user.setUsername(email.substring(0, email.indexOf("@")));
			user.setPassword(password);
			user = userRepository.save(user);
			return new ResponseEntity<String>("Successful", HttpStatus.OK);

		} else {
			throw new Exception("already exist");
		}

	}

	@GetMapping("/allUser")
	public ResponseEntity<?> getallUser() {

		List<UserEntity> user = userRepository.findAll();

		return new ResponseEntity<List<UserEntity>>(user, HttpStatus.OK);

	}

	@GetMapping("/CheckingByPasswordAndEmail")
	public ResponseEntity<?> getallUserbyEmailandPassword(@RequestParam String password, @RequestParam String email) {

		UserEntity user = userRepository.findByEmailAndPassword(email, password);

		if (user == null) {
			return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<UserEntity>(user, HttpStatus.OK);

		}

	}

	@PostMapping("/createQustions")
	public ResponseEntity<?> createQustions(@RequestParam String email, @RequestParam String qustions)
			throws Exception {
		
		List<UserEntity> newUser =userRepository.findByEmail(email);
		List<QustionsEntity> listQ = new ArrayList<>();
		QustionsEntity q = new QustionsEntity();
		q.setQustions(qustions);
			
			q.setDate(new Date());

			q.setUser_qustion(newUser.get(0));
			listQ.add(q);
			newUser.get(0).setQustionsEntity(listQ);
			userRepository.save(newUser.get(0));
			
			return new ResponseEntity<String>("Done ", HttpStatus.OK);
		
	}
	
}
