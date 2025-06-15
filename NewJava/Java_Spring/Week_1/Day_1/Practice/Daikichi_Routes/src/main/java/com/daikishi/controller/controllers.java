package com.daikishi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllers {
	@RequestMapping("/daikichi")
	public String greeting() {
		return "Welcome";
	}
	
	@RequestMapping("/daikichi/today")
	public String today() {
		return "Today you will find luck";
	}
	
	@RequestMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return "tomorrow an oportunitywill arise so be sure tobe open to new ideas";
	}
}
