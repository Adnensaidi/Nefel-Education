package com.daikishi.controller;

import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/daikichi/travel/{location}")
	public String travel(@PathVariable("location") String location){
		return "congrats you will travel to "+ location;
	}
	
	@RequestMapping("/daikichi/lotto/{age}")
	public String lotto(@PathVariable("age") int age) {
		String expresion = age % 2 == 0 ?  "you will take a good jorny..." :  "go have fun with your family ...";
		return expresion;
	}
	
}
