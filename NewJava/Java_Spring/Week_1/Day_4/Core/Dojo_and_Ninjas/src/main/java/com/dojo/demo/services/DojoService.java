package com.dojo.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.demo.models.Dojo;
import com.dojo.demo.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepo;
	
	public List<Dojo> getAll(){
		return dojoRepo.findAll();
	}
	
	public Dojo getById(long id){
		Optional<Dojo> d = dojoRepo.findById(id);
		if(d.isEmpty()) {
			return null;
		}
		return d.get();
	}
	
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
