package com.human.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@RequestMapping("/")
	public String human(@RequestParam(value="name", required = false) String name,
						@RequestParam(value="lastname", required = false) String lastname ) {
		if(name!=null && lastname==null) {
			return "Hello "+ name;
		}else if(name!=null && lastname!=null) {
			return "Hello "+ name +" "+ lastname;
		}else {
			return "Hello human";
		}
	}
	
}
