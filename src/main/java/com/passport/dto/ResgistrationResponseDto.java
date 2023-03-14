package com.passport.dto;

import java.time.LocalDate;

public class ResgistrationResponseDto {
	private long id;
	private String name;
	private String username;
	private LocalDate dob;
	private String gender;
	private String phone;
	private String presentAddress;
	private String permanentAddress;
	private String password;
	private String roles;
	
	public ResgistrationResponseDto(long id, String name, String username, LocalDate dob, String gender, String phone,
			String presentAddress, String permanentAddress, String password, String roles) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.password = password;
		this.roles = roles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
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
		return "ResgistrationResponseDto [id=" + id + ", name=" + name + ", username=" + username + ", dob=" + dob
				+ ", gender=" + gender + ", phone=" + phone + ", presentAddress=" + presentAddress
				+ ", permanentAddress=" + permanentAddress + ", password=" + password + ", roles=" + roles + "]";
	}
	public ResgistrationResponseDto(String name, String username, LocalDate dob, String gender, String phone,
			String presentAddress, String permanentAddress, String password, String roles) {
		super();
		this.name = name;
		this.username = username;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.password = password;
		this.roles = roles;
	}
	public ResgistrationResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
