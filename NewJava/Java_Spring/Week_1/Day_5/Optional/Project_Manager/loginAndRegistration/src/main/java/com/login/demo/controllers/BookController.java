package com.login.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.login.demo.models.Book;
import com.login.demo.services.BookService;
import com.login.demo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	BookService bookServ;
	
	@Autowired
	UserService userServ;
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getById((long)session.getAttribute("userId")));
		model.addAttribute("allBooks", bookServ.getAll());
		return "home";
		
	}
	
	@GetMapping("/books/create")
	public String displayCreate(@ModelAttribute Book book, HttpSession session) {
		
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		
		return "create";
	}
	
	@PostMapping("/books/new")
	public String treatForm(@Valid @ModelAttribute Book book, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "create";
		}
		book.setUser(userServ.getById((long)session.getAttribute("userId")));
		bookServ.create(book);
		return "redirect:/home";
		
	}
	
	@GetMapping("/books/view/{bookId}")
	public String bookDetails(HttpSession session, @PathVariable long bookId, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		model.addAttribute("book",bookServ.getById(bookId));
		return "view";
		
	}
	
	@GetMapping("/books/edit/{bookId}")
	public String viewEdit(@ModelAttribute Book book, HttpSession session, Model model, @PathVariable long bookId) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		model.addAttribute("book",bookServ.getById(bookId));
		return "edit";
	}
	
	@PostMapping("/books/edit/{bookId}")
	public String handleEdit(@Valid @ModelAttribute Book book, BindingResult result, HttpSession session, @PathVariable long bookId, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("book",bookServ.getById(bookId));
			return "edit";
		}
		bookServ.edit(book, bookId, userServ.getById((long)session.getAttribute("userId")));
		return "redirect:/home";
	}
}
