package com.passport.dto;

public class UsersRequest {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String roles;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UsersRequest [first_name=" + first_name + ", last_name=" + last_name + ", username=" + username
				+ ", password=" + password + ", roles=" + roles + "]";
	}
	public UsersRequest(String first_name, String last_name, String username, String password, String roles) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public UsersRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
