package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.QustionsEntity;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@RestController
@CrossOrigin
public class loginCntroller {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/addUser")
	public ResponseEntity<?>addUser(

			@RequestParam String Firstname, @RequestParam String Lasttname, @RequestParam String username,
			@RequestParam String password, @RequestParam String email  ) throws Exception {
		
	
		User CheckUser = userRepository.findByEmail(email);

		if (CheckUser == null) {
			
			User user = new User();
			user.setFirstname(Firstname);
			user.setLasttname(Lasttname); 

			user.setEmail(email);
			user.setUsername(email.substring(0,email.indexOf("@")));
			user.setPassword(password);
			user = userRepository.save(user);
			return new ResponseEntity<String>("Successful", HttpStatus.OK);

		} else {
			throw new  Exception("already exist");
		}

	
	
	

	}

	@GetMapping("/allUser")
	public ResponseEntity<?> getallUser() {

		List<User> user = userRepository.findAll();

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);

	}

	@GetMapping("/CheckingByPasswordAndEmail")
	public ResponseEntity<?> getallUserbyEmailandPassword(@RequestParam String password, @RequestParam String email) {

		User user = userRepository.findByEmailAndPassword(email, password);

		if (user == null) {
			return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);

		}

	}
	
	
}
