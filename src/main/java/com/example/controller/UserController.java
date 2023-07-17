package com.example.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserServices;

@RestController
public class UserController extends BaseController {

	@PostMapping("/saveDetails")
	public ResponseEntity<Map> saveDetails(@RequestBody User user) {

		Map<String, Object> m = new HashMap<>();
		try {
			User savedUser = userRepository.save(user);
			m.put("Message", "User Details Saved Successfully");
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

		Map<String, Object> m = new HashMap<>();
		try {
			m.put("Users List", userRepository.findAll());
			m.put("status", true);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			m.put("Error Message", "List Can't Be Retrieved");
			m.put("status", false);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(m);
		}
	}

	@GetMapping("/getListById/{id}")
	public ResponseEntity<Map> getListById(@PathVariable String id) {

		Map<String, Object> m = new HashMap<>();
		try {
			m.put("User", userServices.findById(Integer.parseInt(id)));
			m.put("status", true);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			m.put("Error Message", "List Can't Be Retrieved");
			m.put("status", false);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(m);
		}
	}

	@GetMapping("/getListByIdAndName/{id}/{name}")
	public ResponseEntity<Map> getListByIdAndName(@PathVariable String id, @PathVariable String name) {

		Map<String, Object> m = new HashMap<>();
		try {
			m.put("User", userServices.findByIdAndName(Integer.parseInt(id), name));
			m.put("status", true);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			m.put("Error Message", "List Can't Be Retrieved");
			m.put("status", false);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(m);
		}
	}

	@GetMapping("/getListByIdAndNameAndEmail/{id}/{name}/{email}")
	public ResponseEntity<Map> getListByIdAndNameAndEmail(@PathVariable String id, @PathVariable String name,
			@PathVariable String email) {

		Map<String, Object> m = new HashMap<>();
		try {
			m.put("User", userServices.findByIdAndNameAndEmail(Integer.parseInt(id), name, email));
			m.put("status", true);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			m.put("Error Message", "List Can't Be Retrieved");
			m.put("status", false);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(m);
		}

	}

	/*
	 * @GetMapping("/getListByFromdateAndTodate") public ResponseEntity<Map>
	 * getListByFromdateAndTodate(@RequestBody User user) {
	 * 
	 * Map m = new HashMap(); List<User> userList =
	 * userServices.findBydateBetween(user.getFromdate(), user.getTodate());
	 * 
	 * try { m.put("User", userList); m.put("status", true); return new
	 * ResponseEntity<Map>(m, HttpStatus.OK); } catch (Exception e) {
	 * m.put("Error Message", "List Can't Be Retrieved"); m.put("status", false);
	 * return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

	@GetMapping("/getListByFromdateAndTodate")
	public ResponseEntity<Map<String, Object>> getListByFromdateAndTodate(@RequestParam Date fromdate ,@RequestParam Date todate) {
		Map<String, Object> response = new HashMap<>();

		try {
			List<User> userList = userServices.findByDateBetween(fromdate, todate);
			response.put("User", userList);
			response.put("status", true);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("status", false);
			response.put("Error Message", "List Can't Be Retrieved");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}
