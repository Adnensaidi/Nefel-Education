package com.login.demo.models;

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
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    
		    @NotBlank
		    @Pattern(regexp = "[a-zA-Z]+\\.?")
		    private String username;
		    
		    @Email
		    private String email;
		    
		    @Size(min = 8)
		    private String password;
		    
		    @Transient
		    @Size(min = 8)
		    private String confpw;
		    
		    @OneToMany(fetch = FetchType.EAGER, mappedBy = "creator", cascade = CascadeType.ALL)
		    List<Project> myprojects;
		    
		    
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
		    public User() {
		    	
		    }

			public User(Long id, @NotBlank @Pattern(regexp = "[a-zA-Z]+\\.?") String username, @Email String email,
					@Size(min = 8) String password, @Size(min = 8) String confpw, List<Project> myprojects,
					Date createdAt, Date updatedAt) {
				super();
				this.id = id;
				this.username = username;
				this.email = email;
				this.password = password;
				this.confpw = confpw;
				this.myprojects = myprojects;
				this.createdAt = createdAt;
				this.updatedAt = updatedAt;
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getConfpw() {
				return confpw;
			}

			public void setConfpw(String confpw) {
				this.confpw = confpw;
			}

			public List<Project> getMyprojects() {
				return myprojects;
			}

			public void setMyprojects(List<Project> myprojects) {
				this.myprojects = myprojects;
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
