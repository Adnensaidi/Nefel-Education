package com.ninjagoldgame.demo.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;






@Controller
public class MainController {
	
	
	int playergold=0;
	ArrayList<String> actions= new ArrayList<>();
		
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("playergold", playergold);
		return "index.jsp";
	}
	
	@PostMapping("/game")
	public String game(@RequestParam String gold, HttpSession session) {
		Random r = new Random();
		LocalDateTime myDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String date = myDate.format(formatter);
		if(gold.equals("farm")) {
			int earnedgold = r.nextInt(10, 21); 
			playergold += earnedgold;
			actions.add(String.format("you entered a farm and earned %s( %s )", earnedgold, date ));
			session.setAttribute("actions", actions);
			session.setAttribute("playergold", playergold);
			return "redirect:/";
		}
		if(gold.equals("cave")) {
			int earnedgold = r.nextInt(5, 11); 
			playergold += earnedgold;
			actions.add(String.format("you entered a cave and earned %s gold ( %s )", earnedgold, date ));
			session.setAttribute("actions", actions);
			session.setAttribute("playergold", playergold);
			return "redirect:/";
		}
		if(gold.equals("house")) {
			int earnedgold = r.nextInt(2, 5); 
			playergold += earnedgold;
			actions.add(String.format("you entered a house and earned %s gold ( %s )", earnedgold, date ));
			session.setAttribute("actions", actions);
			session.setAttribute("playergold", playergold);
			return "redirect:/";
		}
		if(gold.equals("quest")) {
			int earnedgold = r.nextInt(21);
			int test = r.nextInt(0,2);
			if(test == 0) {
				playergold -= earnedgold;
				actions.add(String.format("you entered a quest and lost %s gold ( %s )", earnedgold, date ));
				

			}else {
				playergold += earnedgold;
				actions.add(String.format("you entered a quest and earned %s gold ( %s )", earnedgold, date ));
			}
			session.setAttribute("actions", actions);
			session.setAttribute("playergold", playergold);
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		playergold=0;
		actions= new ArrayList<>();
		session.setAttribute("actions", actions);
		session.setAttribute("playergold", playergold);
		return "redirect:/";
	}
}
