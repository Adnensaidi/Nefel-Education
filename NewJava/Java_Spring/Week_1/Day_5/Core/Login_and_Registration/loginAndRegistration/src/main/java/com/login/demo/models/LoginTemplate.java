package com.login.demo.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class LoginTemplate {
	
    @Email
    private String email;
    
    @Size(min = 8)
    private String password;
    
    public LoginTemplate() {
    	
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
    
    
}
