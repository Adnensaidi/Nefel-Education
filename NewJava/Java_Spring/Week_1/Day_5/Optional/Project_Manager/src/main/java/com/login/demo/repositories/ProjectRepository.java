package com.login.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.demo.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	public List<Project> findAll();
	
	public Optional<Project> findById(Long id);
	
	
	
}
