package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.repository.UserRepository;
import com.example.service.UserServices;

public class BaseController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServices userServices;

}
