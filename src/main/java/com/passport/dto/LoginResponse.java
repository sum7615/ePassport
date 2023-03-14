package com.passport.dto;

import java.util.Objects;

public class LoginResponse {
	
	private String username;
	private String accessToken;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	@Override
	public String toString() {
		return "LoginResponse [username=" + username + ", accessToken=" + accessToken + "]";
	}
	public LoginResponse(String username, String accessToken) {
		super();
		this.username = username;
		this.accessToken = accessToken;
	}
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(accessToken, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginResponse other = (LoginResponse) obj;
		return Objects.equals(accessToken, other.accessToken) && Objects.equals(username, other.username);
	}
	

}
