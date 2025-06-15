package com.omikikujiform.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String goToIndex() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/Send")
	public String formTreat(@RequestParam(required=false) String years,@RequestParam(required=false) String city,@RequestParam(required=false) String rmate,@RequestParam(required=false) String job,@RequestParam(required=false) String animal,@RequestParam(required=false) String snice, RedirectAttributes redirectAttribute, HttpSession session ) {
		System.out.println(years+" "+city+" "+rmate+" "+job+" "+animal+" "+snice);
		if(years.isBlank()) {
			redirectAttribute.addFlashAttribute("yearsInvalid", "Please enter a valid number !");
			return "redirect:/omikuji";
		}
		if( Integer.parseInt(years) < 1 || Integer.parseInt(years) > 25) {
			redirectAttribute.addFlashAttribute("yearsInvalid", "Please enter a valid number !");
			return "redirect:/omikuji";
		}
		if( city.isBlank() || rmate.isBlank() || job.isBlank() || animal.isBlank() || snice.isBlank()) {
			redirectAttribute.addFlashAttribute("blankInvalid", "Please fill all feilds !");
			return "redirect:/omikuji";
		}
		session.setAttribute("years", years);
		session.setAttribute("city", city);
		session.setAttribute("rmate", rmate);
		session.setAttribute("job", job);
		session.setAttribute("animal", animal);
		session.setAttribute("snice", snice);

		
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String view() {
		return "view.jsp";
	}
}
