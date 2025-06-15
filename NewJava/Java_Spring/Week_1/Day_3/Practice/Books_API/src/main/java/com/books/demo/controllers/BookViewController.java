package com.books.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.books.demo.servises.BookService;

@Controller
public class BookViewController {
	
	@Autowired
	BookService bookserv;
	
	@GetMapping("/books/{id}")
	public String showOne(Model model, @PathVariable long id) {
		model.addAttribute("book",bookserv.findBook(id));
		return "show";
	}
	
	@GetMapping("/books")
	public String showAll(Model model) {
		model.addAttribute("allBooks", bookserv.allBooks());
		return "showAll";
	}
	
	
}
