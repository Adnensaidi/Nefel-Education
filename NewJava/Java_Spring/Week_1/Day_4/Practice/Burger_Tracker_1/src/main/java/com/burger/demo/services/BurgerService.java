package com.burger.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger.demo.models.Burger;
import com.burger.demo.repositories.BurgerRepository;

@Service
public class BurgerService {

	@Autowired
	BurgerRepository burgerRepo;
	
	public Burger create(Burger b) {
		return burgerRepo.save(b);
	}
	
	public List<Burger> getAll() {
		return burgerRepo.findAll();	}
	
	public Burger edit(Burger b, long id) {
		b.setId(id);
		return burgerRepo.save(b);
	}
	
	public Burger getOne(long id) {
		Optional<Burger> b = burgerRepo.findById(id);
		if(b.isEmpty()) {
			return null;
		}
		return b.get();
				
	}
}
