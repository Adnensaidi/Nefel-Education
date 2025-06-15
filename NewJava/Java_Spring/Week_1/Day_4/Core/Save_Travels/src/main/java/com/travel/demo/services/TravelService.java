package com.travel.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.demo.models.Travel;
import com.travel.demo.repositories.TravelRepository;

@Service
public class TravelService {
	
	@Autowired
	TravelRepository trepo;
	
	public Travel create(Travel travel) {
		return trepo.save(travel);
	}
	
	public List<Travel> getAll(){
		return trepo.findAll();
	}
	
	public Travel findId(long id) {
		Optional<Travel> t = Optional.ofNullable(trepo.findById(id));
		if(t.isEmpty()) {
			return null;
		}
		return t.get();
	}
	
	public Travel edit(Travel t, long id) {
		t.setId(id);
		return trepo.save(t);
	}
	
	public void delete(long id) {
		trepo.deleteById(id);
	}

}
