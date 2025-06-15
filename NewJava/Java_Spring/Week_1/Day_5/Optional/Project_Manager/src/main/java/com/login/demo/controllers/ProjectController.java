package com.login.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.demo.models.Project;
import com.login.demo.services.ProjectService;
import com.login.demo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {

	@Autowired
	UserService userServ;

	@Autowired
	ProjectService projectServ;

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}

		model.addAttribute("user", userServ.getById((Long) session.getAttribute("userId")));
		model.addAttribute("allProjects", projectServ.getAll());
		return "home";

	}

	@GetMapping("/projects/create")
	public String create(@ModelAttribute Project project, HttpSession session) {

		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		return "create";
	}

	@PostMapping("/projects/create")
	public String create(@Valid @ModelAttribute Project project, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return "create";
		}

		project.setCreator(userServ.getById((long) session.getAttribute("userId")));
		projectServ.create(project);
		return "redirect:/home";
	}


	  @GetMapping("/projects/edit/{id}")
	  public String showEdit(@ModelAttribute
	  Project project, Model model, HttpSession session, @PathVariable long id) {
	  if(session.getAttribute("userId")==null) {
		  return "redirect:/logout";
		  }
	  
	  	model.addAttribute("project", projectServ.getById(id));
	  	return "edit";
	  }
	  
	  @PostMapping("/projects/edit/{id}")
	  public String handleEdit(@Valid @ModelAttribute Project project, BindingResult result, HttpSession session, @PathVariable long id) {
		  if(result.hasErrors()) {
			  project.setId(id);
			  project.setCreator(userServ.getById((long)session.getAttribute("userId")));
			  return "edit";
		  }
		  
		  projectServ.edit(project, id, userServ.getById((long)session.getAttribute("userId")));
		  return "redirect:/home";
		  
		  
	  }
	  
	  @GetMapping("/projects/view/{id}")
	  public String viewDetails(@PathVariable long id, Model model, HttpSession session) {
		  
		  if(session.getAttribute("userId")==null) {
			  return "redirect:/logout";
		  }
		  
		  model.addAttribute(projectServ.getById(id));
		  
		  return "details";
	  }
	  


}
