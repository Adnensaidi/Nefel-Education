package com.books.demo.controllers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.demo.models.Book;
import com.books.demo.servises.BookService;
@RestController
public class BookController {
 private final BookService bookService;
 public BookController(BookService bookService){
     this.bookService = bookService;
 }
 @PostMapping("/create")
 public Book create() {
	 return bookService.createBook(new Book("title", "desczzzz", "langzz", 180));
 }
 
 
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
 public Book update(
 		@PathVariable("id") Long id, 
 		@RequestParam(value="title") String title, 
 		@RequestParam(value="description") String desc, 
 		@RequestParam(value="language") String lang,
 		@RequestParam(value="pages") Integer numOfPages) {
     Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
     return book;
 }
 
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
 }
}

