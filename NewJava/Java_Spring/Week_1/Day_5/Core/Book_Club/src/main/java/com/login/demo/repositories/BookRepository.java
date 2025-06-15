package com.login.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.demo.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
	
	public List<Book> findAll();
	
	public Book getById(Long id);
	
	public void deleteById(Long id);
	
	
}
