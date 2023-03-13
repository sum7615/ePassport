package com.passport.dto;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
//import jakarta.xml.bind.annotation.XmlEnumValue;

public class UserDTO {

	private long id;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z\\s]*[a-zA-Z]+$", message = "Name must contain only letters and spaces")
	private String name;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9_]+@+[a-zA-Z]+.+[a-zA-Z]$", message = "Username must start with uppercase or lowercase letter and contain one @ and . also like abc@xyz.com")
	private String username;

	@NotBlank
	@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Phone number must be a valid Indian number")
	private String phone;

	@NotBlank
	@Pattern(regexp = "^[\\w\\s,.#-]+,[\\w\\s]+,[\\w\\s]+,[A-Za-z\\s]+,[0-9]+$", message = "Address must be in the format: street, city, state, country, zipcode. Ex: North street,Banglore,Karnataka,India,799130")
	private String presentAddress;
	
	@NotBlank
	@Pattern(regexp = "^[\\w\\s,.#-]+,[\\w\\s]+,[\\w\\s]+,[A-Za-z\\s]+,[0-9]+$", message = "Address must be in the format: street, city, state, country, zipcode. Ex: North street,Banglore,Karnataka,India,799130")
	private String permanentAddress;
	
	@NotBlank
	@Size(min = 8, max= 30)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
	private String password;
     
	@NotBlank
	private String gender;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="testdate")
	@NotNull(message = "TestDate is not valid")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDate dob;
	
	private String roles;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(long id, String name, String username, String phone, String presentAddress, String permanentAddress,
			String password, String gender, LocalDate dob, String roles) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.phone = phone;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.roles = roles;
	}
	

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", username=" + username + ", phone=" + phone
				+ ", presentAddress=" + presentAddress + ", permanentAddress=" + permanentAddress + ", password="
				+ password + ", gender=" + gender + ", dob=" + dob + ", roles=" + roles + "]";
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	
}

