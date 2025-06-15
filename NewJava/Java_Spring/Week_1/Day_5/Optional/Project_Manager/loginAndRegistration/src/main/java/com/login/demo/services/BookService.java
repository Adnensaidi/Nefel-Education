package com.login.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.demo.models.Book;
import com.login.demo.models.User;
import com.login.demo.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	public Book getById(long id) {
		
		Optional<Book> b = Optional.ofNullable(bookRepo.getById(id));
		
		if(b.isEmpty()) {
			return null;
		}
		return b.get();
	}
	
	public Book edit(Book book, long id, User user) {
		book.setId(id);
		book.setUser(user);
		return bookRepo.save(book);
	}
	
	
}
