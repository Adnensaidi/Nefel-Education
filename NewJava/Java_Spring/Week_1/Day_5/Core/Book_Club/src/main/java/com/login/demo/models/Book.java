package com.login.demo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book {
	
	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 	
 	@NotBlank
 	private String title;
 	
 	@NotBlank
 	private String author;
 	
 	@NotBlank
 	private String mytho;
 	
 	@ManyToOne(fetch = FetchType.EAGER)
 	@JoinColumn(name = "user_id")
 	User user;
 	
    @Column(updatable=false)
    private Date createdAt;

    private Date updatedAt;

    // methods
    @PrePersist
    protected void onCreate() {
    this.createdAt=new Date();
    this.updatedAt=new Date();
    }
    
    public Book() {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMytho() {
		return mytho;
	}

	public void setMytho(String mytho) {
		this.mytho = mytho;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Book(Long id, @NotNull String title, @NotNull String author, @NotNull String mytho, User user,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.mytho = mytho;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@PreUpdate
    protected void onUpdate() {
    this.updatedAt=new Date();
    }
}
