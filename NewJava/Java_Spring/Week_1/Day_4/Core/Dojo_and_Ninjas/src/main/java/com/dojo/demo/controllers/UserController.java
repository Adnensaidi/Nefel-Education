package com.dojo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.demo.models.User;
import com.dojo.demo.services.DojoService;
import com.dojo.demo.services.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userServ;
	@Autowired
	DojoService dojoServ;
	
	@GetMapping("/ninjas/new")
	public String userForm(@ModelAttribute User user, Model model) {
		
		model.addAttribute("allDojos",dojoServ.getAll());
		
		return "user";
	}
	
	@PostMapping("/ninjas/create")
	public String handleForm(@Valid @ModelAttribute User user, BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.getAll());
			return "user";
		}
		userServ.create(user);
		return "redirect:/";
	}
	

	
}
