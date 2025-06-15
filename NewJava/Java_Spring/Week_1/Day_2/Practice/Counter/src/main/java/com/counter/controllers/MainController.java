package com.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;



@Controller
public class MainController {
	int counter = 0;
	
	@GetMapping("/")
	public String red(HttpSession session) {
		session.setAttribute("counter", counter);
		return "redirect:/your_server/counter";
	}
	
	@GetMapping("/your_server")
	public String index(HttpSession session) {
		counter++;
		session.setAttribute("counter", counter);
		return "index.jsp";
	}
	
	
	@GetMapping("/your_server/counter")
	public String counterMethod() {
		return "counter.jsp";
	}
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		counter = 0;
		session.invalidate();
		return "redirect:/";
	}
	
}
