package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;


@Service
public class UserServices {

	@Autowired
	UserRepository userRepository;
	
	public User findById(int id) {
		
		Optional<User> optional= userRepository.findById(id);
		User user=optional.get();
		return user;
	}

	public User findByIdAndName(int id,String name) {
		Optional<User> optional= userRepository.findByIdAndName(id,name);
		User user=optional.get();
		return user;
	}

}
