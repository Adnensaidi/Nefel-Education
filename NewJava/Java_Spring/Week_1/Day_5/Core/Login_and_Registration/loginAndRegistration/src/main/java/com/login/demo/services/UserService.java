package com.login.demo.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.login.demo.models.LoginTemplate;
import com.login.demo.models.User;
import com.login.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	public User getByEmail(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		if(user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	
	public User getById(long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	
	public User register(User newUser,BindingResult result) {
		
		if(getByEmail(newUser.getEmail()) != null) {
			result.rejectValue("email","uniqueness","Email already exists");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfpw())) {
			 result.rejectValue("confirm","match","password and confirm does not match ");
		 }
		
		if(result.hasErrors()) {
			 return null;
		 }
		
		String hashed=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		
		newUser.setPassword(hashed);
		
		return userRepo.save(newUser);
	}
	
	public User login(LoginTemplate newLogin,BindingResult result) {
		
		if(getByEmail(newLogin.getEmail()) == null) {
			result.rejectValue("email","not found","Email is not found");
		}
		
		User user = this.getByEmail(newLogin.getEmail());
		
		if(result.hasErrors()) {
			return null;
		}
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password","wrong","wrong Credentials !!!");
		}
		
	return user;
		
		
	}
	
	
	
}
