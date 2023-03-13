package com.passport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PassportOffice {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Id")
	private long id;
	
	@Column(name="OfficeName")
	private String name;
	
	@Column(name="JurisdictionName")
	private String jurisdiction;
	
	@Column(name="PhoneNumber")
	private int phoneNumber;
	
	@Column(name="Address")
	private String address;

	
}
