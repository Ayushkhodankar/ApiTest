package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserServices;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServices userServices;

	@PostMapping("/saveDetails")
	public ResponseEntity<Map> saveDetails(@RequestBody User user) {
		Map m= new HashMap();
		try {
			User savedUser = userRepository.save(user);
			m.put("Message","User Details Saved Successfully");
			m.put("status", true);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} catch (Exception e) {
			m.put("Users List", "List Can't Be Retrieved");
			m.put("status", false);
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/UsersList")
	public ResponseEntity<Map> UsersList() {

		Map m = new HashMap();
		try {
			m.put("Users List", userRepository.findAll());
			m.put("status", true);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} catch (Exception e) {
			m.put("Error Message", "List Can't Be Retrieved");
			m.put("status", false);
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getListById/{id}")
	public ResponseEntity<Map> getListById(@PathVariable String id) {
		
		Map m = new HashMap();
		try {
			m.put("User", userServices.findById(Integer.parseInt(id)));
			m.put("status", true);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} catch (Exception e) {
			m.put("Error Message", "List Can't Be Retrieved");
			m.put("status", false);
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getListByIdAndName/{id}/{name}")
	public ResponseEntity<Map> getListByIdAndName(@PathVariable String id,@PathVariable String name) {
		
		Map m = new HashMap();
		try {
			m.put("User", userServices.findByIdAndName(Integer.parseInt(id),name));
			m.put("status", true);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} catch (Exception e) {
			m.put("Error Message", "List Can't Be Retrieved");
			m.put("status", false);
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
