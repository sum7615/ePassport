package com.passport.dto;

public class PassportOfficeDto {

	private long id;
	private String name;
	private String jurisdiction;
	private int phoneNumber;
	private String address;
	public PassportOfficeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassportOfficeDto(long id, String name, String jurisdiction, int phoneNumber, String address) {
		super();
		this.id = id;
		this.name = name;
		this.jurisdiction = jurisdiction;
		this.phoneNumber = phoneNumber;
		this.address = address;
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
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
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
		return "PassportOfficeDto [id=" + id + ", name=" + name + ", jurisdiction=" + jurisdiction + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
	
	
}
