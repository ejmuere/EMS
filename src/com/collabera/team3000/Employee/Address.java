package com.collabera.team3000.Employee;

import java.io.Serializable;

/**
 * The is the address class which has a hasa relationship to the employee class 
 * @author joshe_000
 *
 */

public class Address implements Serializable{

	//country string
	//state string
	//city string
	//zipCode int
	
	
	private String country;
	private String state;
	private String city;
	private String zipCode;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String toString() {
		return "Country: " + this.getCountry() + " State: " + this.getState() + " City: " + this.getCity() +
				" Zip Code: " + this.getZipCode();
	}
		
}
