package com.dojo.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.demo.models.Dojo;
import com.dojo.demo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	

	 List<User> findAll();
	 List<User> findByDojo(Dojo dojo);
}
