package com.dojo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.demo.models.Dojo;
import com.dojo.demo.services.DojoService;
import com.dojo.demo.services.UserService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoServ;
	@Autowired
	UserService userServ;
	
	@GetMapping("/dojos/new")
	public String createForm(@ModelAttribute Dojo dojo) {
		return "dojo";
	}
	
	@PostMapping("/dojos/create")
	public String handleForm(@Valid @ModelAttribute Dojo dojo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "dojo";
		}
		dojoServ.create(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/dojos/{id}")
	public String showByDojo(Model model, @PathVariable long id) {
		model.addAttribute("ninjas",userServ.getUserDojos(dojoServ.getById(id)));
		return "show";
	}
}
