package com.travel.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.demo.models.Travel;
import com.travel.demo.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	
	@Autowired
	TravelService tservice;
	
	@GetMapping("/")
	public String goToIndex() {
		return "redirect:/expences";
	}
	
	@GetMapping("/expences")
	public String viewIndex(@ModelAttribute Travel travel, Model model) {
		model.addAttribute("allExpences",tservice.getAll());
		return "index";
	}
	
	@PostMapping("/expences/create")
	public String treatCreate(@Valid @ModelAttribute Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allExpences",tservice.getAll());
			return "index";
		}
		tservice.create(travel);
		return "redirect:/expences";
	}
	
	@GetMapping("/expences/edit/{id}")
	public String viewEdit(@ModelAttribute Travel travel, @PathVariable long id, Model model) {
		model.addAttribute("travel", tservice.findId(id));
		return "edit";
	}
	
	@PostMapping("/expences/test/{id}")
	public String treatEdit(@Valid @ModelAttribute Travel travel, BindingResult result, @PathVariable long id,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("travel", tservice.findId(id));
			return "edit";
		}
		tservice.edit(travel, id);
		System.out.println(tservice.edit(travel, id));
		return "redirect:/expences";
	}
	
	@GetMapping("expences/{id}")
	public String showDetails(@PathVariable long id, Model model) {
		model.addAttribute("travel", tservice.findId(id));
		return "details";
	}
	
	@PostMapping("expences/delete")
	public String treatDelete(@RequestParam long id) {
		tservice.delete(id);
		return "redirect:/expences";
	}
	
}
