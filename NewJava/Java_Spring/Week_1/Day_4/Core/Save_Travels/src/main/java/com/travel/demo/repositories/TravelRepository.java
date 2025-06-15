package com.travel.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.travel.demo.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {
	
	List<Travel> findAll();
	Travel findById(long id);
	
}
