package com.login.demo.models;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="projects")
public class Project {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	  @NotBlank
	  private String title;
	   
	  @NotBlank
	  private String description;
	   
	  @FutureOrPresent
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private LocalDate duedate;
	   
	  @ManyToOne
	  @JoinColumn(name="userId")
	  User creator;
	  
	  @Column(updatable=false)
	  private Date createdAt;
	
	  private Date updatedAt;
	
	 // methods
	  @PrePersist
	  protected void onCreate() {
		  this.createdAt=new Date();
		  this.updatedAt=new Date();
		}
		
	  @PreUpdate
	  protected void onUpdate() {
		  this.updatedAt=new Date();
		}

	

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	public Project(Long id, @NotBlank String title, @NotBlank String description, @FutureOrPresent LocalDate duedate,
			User creator, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.duedate = duedate;
		this.creator = creator;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Project() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	 
	
	  
}
