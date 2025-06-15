package com.travel.demo.models;

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
@Table(name="travels")
public class Travel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    
    @NotBlank
    @NotNull
    private String vendor;
    
    @NotNull
    private double amount;
    
    @NotBlank
    @NotNull
    private String description;
    
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
    
    public Travel() {
    	
    }

	public Travel(Long id, @NotBlank @NotNull String name, @NotBlank @NotNull String vendor,
			@NotBlank @NotNull double amount, @NotBlank @NotNull String description, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
