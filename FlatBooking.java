package com.ofr.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="flat_booking_2")
public class FlatBooking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int	bookingNo;

	@OneToOne(cascade=CascadeType.MERGE)
	@JoinTable(name="flat_FlatBooking")
	private Flat flat;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinTable(name="tenant_FlatBooking")
	private Tenant tenant;
	
	@Column
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingFromDate;
	
	@Column
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingToDate;
	
	
	public FlatBooking() {}
	public FlatBooking( Flat flat, Tenant tenant, LocalDate bookingFromDate, LocalDate bookingToDate) {
		super();
	
		this.flat = flat;
		this.tenant = tenant;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}
	
	public int getBookingNo() {
		return bookingNo;
	}
	
	public Flat getFlat() {
		return flat;
	}
	public void setFlat(Flat cost) {
		this.flat = cost;
	}
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}
	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}
	
	@Override
	public String toString() {
		return "FlatBooking [bookingNo=" + bookingNo + ", flat=" + flat + ", tenant=" + tenant
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}
	
	

}
