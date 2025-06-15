package com.burger.demo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="burgers")
public class Burger {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String restaurant_name;
	@NotNull
	private int rateing;
	@NotNull
	@NotBlank
	private String notes;
	
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
	public Burger () {
		
	}



	public Burger(Long id, @NotNull @NotBlank String name, @NotNull @NotBlank String restaurant_name,
			@NotNull int rateing, @NotNull @NotBlank String notes, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.restaurant_name = restaurant_name;
		this.rateing = rateing;
		this.notes = notes;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public int getRateing() {
		return rateing;
	}

	public void setRateing(int rateing) {
		this.rateing = rateing;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
