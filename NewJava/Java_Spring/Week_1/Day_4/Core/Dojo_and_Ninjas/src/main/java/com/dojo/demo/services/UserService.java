package com.dojo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.demo.models.Dojo;
import com.dojo.demo.models.User;
import com.dojo.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User create(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getUserDojos(Dojo dojo){
		return userRepo.findByDojo(dojo);
	}
	
}
