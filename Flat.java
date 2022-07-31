package com.ofr.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="flats_2")
public class Flat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer flatId;
	
	@Column
	@Min(value=300000,message="value should be above 300000")
	@Max(value=5000000,message="value should be below 5000000")
	private Double cost;
	
	@OneToOne(cascade=CascadeType.ALL)
	 
	private FlatAddress flatAddress;
	@Column(name="availability")
	private String availability;
    public Flat() {}
	public Flat(
			@Min(value = 300000, message = "value should be above 300000") @Max(value = 5000000, message = "value should be below 5000000") Double cost,
			FlatAddress flatAddress, String availability) {
		super();
		
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.availability = availability;
	}
	public Integer getFlatId() {
		return flatId;
	}
	
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", availability="
				+ availability + "]";
	}
	
}
