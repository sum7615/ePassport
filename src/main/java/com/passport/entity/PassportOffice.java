package com.passport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class PassportOffice {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private long id;
	
	@Column(name="officeName")
    @NotBlank(message="This field must not be blank")
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z\\s]*[a-zA-Z]+$", message = "Name must contain only letters and spaces")
	private String officeName;
	
	@Column(name="jurisdictionName")
	@NotBlank(message="This field must not be blank")
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z\\s]*[a-zA-Z]+$", message = "Name must contain only letters and spaces")
	private String jurisdictionName;
	
	@Column(name="phoneNumber")
	@NotNull(message="This field must not be blank")
	@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Phone number must be a valid Indian number")
	private String phoneNumber;
	
	@Column(name="address")
	 @NotBlank(message="This field must not be blank")
	@Pattern(regexp = "^[\\w\\s,.#-]+,[\\w\\s]+,[\\w\\s]+,[A-Za-z\\s]+,[0-9]+$", message = "Address must be in the format: street, city, state, country, zipcode. Ex: North street,Banglore,Karnataka,India,799130")
	private String address;

	public PassportOffice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassportOffice(long id, String officeName, String jurisdictionName,String phoneNumber, String address) {
		super();
		this.id = id;
		this.officeName = officeName;
		this.jurisdictionName = jurisdictionName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getJurisdictionName() {
		return jurisdictionName;
	}

	public void setJurisdictionName(String jurisdictionName) {
		this.jurisdictionName = jurisdictionName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PassportOffice [id=" + id + ", officeName=" + officeName + ", jurisdictionName=" + jurisdictionName
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}

	

	
}
