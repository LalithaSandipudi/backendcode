package com.ofr.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//@Embeddable
@Entity
@Table(name="flatAddress_2")
public class FlatAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 
	private int flatAddress_id;
	
	@Column(name="street")
	@NotEmpty
	private String street;
	
	@Column(name="city")
	@NotEmpty
	private String city;
	
	@Column(name="state")
	@NotEmpty
	private String state;
	
	@Column(name="pin")
	@NotNull
	private int pin;
	
	@Column(name="country")
	@NotEmpty
	private String country;
	
	public FlatAddress() {}

	public FlatAddress( @NotEmpty String street, @NotEmpty String city, @NotEmpty String state,
			@NotNull int pin, @NotEmpty String country) {
		super();
		
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
	}

	public int getFlatAddress_id() {
		return flatAddress_id;
	}

	

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "FlatAddress [flatAddress_id=" + flatAddress_id + ", street=" + street + ", city=" + city + ", state="
				+ state + ", pin=" + pin + ", country=" + country + "]";
	}

	
}