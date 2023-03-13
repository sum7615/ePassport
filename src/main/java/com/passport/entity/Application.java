package com.passport.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String fathername;
	private String address;
	private String email;
	private String aadhar;
	private String pan;
	private String qualifiaction;
	private String mobile;
	private LocalDate dob;
	private String gender;
	public Application() {
		
	}
	
	public Application(long id, String name, String fathername, String address, String email, String aadhar, String pan,
			String qualifiaction, String mobile, LocalDate dob, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.fathername = fathername;
		this.address = address;
		this.email = email;
		this.aadhar = aadhar;
		this.pan = pan;
		this.qualifiaction = qualifiaction;
		this.mobile = mobile;
		this.dob = dob;
		this.gender = gender;
	}



	public Application(String name, String fathername, String address, String email, String aadhar, String pan,
			String qualifiaction, String mobile, LocalDate dob, String gender) {
		super();
		this.name = name;
		this.fathername = fathername;
		this.address = address;
		this.email = email;
		this.aadhar = aadhar;
		this.pan = pan;
		this.qualifiaction = qualifiaction;
		this.mobile = mobile;
		this.dob = dob;
		this.gender = gender;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getQualifiaction() {
		return qualifiaction;
	}
	public void setQualifiaction(String qualifiaction) {
		this.qualifiaction = qualifiaction;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
