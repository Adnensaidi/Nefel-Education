package com.dojo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.demo.services.DojoService;
import com.dojo.demo.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userServ;
	@Autowired
	DojoService dojoServ;
	
	@GetMapping("/")
	public String getToIndex() {
		return "redirect:/dojos/new";
	}
}
