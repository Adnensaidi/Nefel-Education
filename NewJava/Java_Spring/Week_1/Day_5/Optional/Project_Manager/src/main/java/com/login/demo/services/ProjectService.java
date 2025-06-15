
package com.login.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.demo.models.Project;
import com.login.demo.models.User;
import com.login.demo.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepo;
	
	public List<Project> getAll(){
		return projectRepo.findAll();
	}
	
	public Project getById(long id) {
		return projectRepo.findById(id).isEmpty() ? null : projectRepo.findById(id).get();
	}
	
	public Project create(Project project) {
		return projectRepo.save(project);
	}
	
	public Project edit(Project project, long id, User Creator) {
		project.setId(id);
		project.setCreator(Creator);
		return projectRepo.save(project);
	}
	
	
}
