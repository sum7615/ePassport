package com.passport.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class LoginRequest {

	private long id;
    private String username;
    private String password;
    
	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}
	
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
