package com.login.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.demo.models.LoginTemplate;
import com.login.demo.models.User;
import com.login.demo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userS;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User user, 
            @ModelAttribute("loginUser") LoginTemplate loginUser,
            HttpSession session) {
		Long sessionId= (Long) session.getAttribute("userId");
		if(sessionId!=null) {
			return "redirect:/home";
		}
		
		
		return "index";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
            BindingResult result,
            HttpSession session,
            Model model) {
		          
		 if(result.hasErrors()) {
		        model.addAttribute("loginUser", new LoginTemplate());
		        return "index";
		    }
		User userInDb=userS.register(newUser, result);
		

		if(result.hasErrors()) {
			model.addAttribute("loginUser",new LoginTemplate());
			return "index";
		}
		
		
		session.setAttribute("userId", userInDb.getId());
		return "redirect:/home";
		
	}
	
	@GetMapping("/home")
	public String home(Model model,HttpSession session) {
		
		

		Long sessionId= (Long) session.getAttribute("userId");

		if(sessionId==null) {
			return "redirect:/";
		}
		

		User connectedUser=userS.getById(sessionId);

		model.addAttribute("connectedUser",connectedUser);
		
		return "home";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginTemplate loginUser,
			             BindingResult result,
			             HttpSession session,
			             Model model) {

		User user =userS.login(loginUser, result);
		

		if(result.hasErrors()) {
			
			model.addAttribute("newUser",new User());

			return "index";
		}

		session.setAttribute("userId", user.getId());
		
		return "redirect:/home";
		
	}
	
	
}
