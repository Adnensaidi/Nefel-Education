package com.dojo.demo.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="dojos")
public class Dojo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String name;
    
    @OneToMany(mappedBy = "dojo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> ninjas;
    
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

	public Dojo() {
	}

	public Dojo(Long id, @NotBlank String name, List<User> ninjas, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.ninjas = ninjas;
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

	public List<User> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<User> ninjas) {
		this.ninjas = ninjas;
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
