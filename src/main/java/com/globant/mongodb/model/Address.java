package com.globant.mongodb.model;

public class Address {
	
	private String address;
	
	private String zip;
	
	private String city;
	
	private String state;
	
	public Address(String address, String zip, String city, String state) {
		super();
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
