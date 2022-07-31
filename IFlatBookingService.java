package com.ofr.service;

import java.time.LocalDate;
import java.util.List;

import com.ofr.entities.Flat;
import com.ofr.entities.FlatBooking;
import com.ofr.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {

	
	public FlatBooking addFlatBooking(FlatBooking flatbooking);

    public List<FlatBooking> getAllFlatBooking();

    public FlatBooking updateFlatBooking(Integer bookingNo,FlatBooking flatbooking1) throws
      FlatBookingNotFoundException;

    public List<FlatBooking> deleteFlatBooking(Integer bookingNo) throws
      FlatBookingNotFoundException;

    public FlatBooking getFlatBooking(Integer bookingNo) throws
      FlatBookingNotFoundException;
	
}
