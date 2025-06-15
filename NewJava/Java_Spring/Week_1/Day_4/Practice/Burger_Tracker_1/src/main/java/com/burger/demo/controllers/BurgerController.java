package com.burger.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.burger.demo.models.Burger;
import com.burger.demo.services.BurgerService;

import jakarta.validation.Valid;


@Controller
public class BurgerController {
	
	@Autowired
	BurgerService bService;
	
	@GetMapping("/")
	public String index(@ModelAttribute Burger burgrer, Model model) {
		model.addAttribute("allBurgers",bService.getAll());
		return "index";
	}
	
	@PostMapping("/burger/new")	
	public String treatCreat(@Valid @ModelAttribute Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allBurgers",bService.getAll());
			return "index";
		}
		bService.create(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burger/edit/{id}")
	public String viewEdit(@ModelAttribute Burger burger,@PathVariable long id, Model model) {
		Burger burgertoedit = bService.getOne(id);
		model.addAttribute("burger",burgertoedit);
		return "edit";
	}
	@PostMapping("/burger/edit/{id}")	
	public String treatEdit(@Valid @ModelAttribute Burger burger, BindingResult result, @PathVariable long id) {
		if(result.hasErrors()) {
			Burger burgertoedit = bService.getOne(id);
			model.addAttribute("burger",burgertoedit);
			return "edit";
		}
		bService.edit(burger, id);
		return "redirect:/";
	}
}
