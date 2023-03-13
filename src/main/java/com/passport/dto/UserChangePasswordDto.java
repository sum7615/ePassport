package com.passport.dto;

public class UserChangePasswordDto {
	private long id;
	private String password;
	
	
	public UserChangePasswordDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserChangePasswordDto(long id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserChangePasswordDto [id=" + id + ", password=" + password + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
