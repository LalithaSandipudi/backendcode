package com.ofr.service;

import java.util.List;

import com.ofr.entities.Flat;
import com.ofr.entities.Landlord;
import com.ofr.exception.LandlordNotFoundException;

public interface ILandlordService {

	public Landlord addLandlord(Landlord landlord);

    
    
    public Landlord updateLandlord(Integer landlordId,Landlord landlord1) throws LandlordNotFoundException;

    public List<Landlord> deleteLandlord(Integer landlordId)throws LandlordNotFoundException;

    public Landlord getLandlord(Integer landlordId) throws LandlordNotFoundException;

    public List<Landlord> getAllLandlord();
	
}
