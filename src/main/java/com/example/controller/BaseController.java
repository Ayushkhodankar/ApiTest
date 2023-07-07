package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exception.FileStorageException;
import com.example.exception.MyFileNotFoundException;
import com.example.property.FileStorageProperties;
import com.example.repository.UserRepository;
import com.example.service.FileStorageService;
import com.example.service.UserServices;

public class BaseController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	FileStorageProperties fileStorageProperties;
	
	@Autowired
	FileStorageService fileStorageService;
	
	@Autowired
	FileStorageException fileStorageException;
	
	@Autowired
	MyFileNotFoundException myFileNotFoundException;
}
