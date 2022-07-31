package com.ofr.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ofr.entities.Flat;
import com.ofr.entities.FlatAddress;
import com.ofr.exception.FlatNotFoundException;
import com.ofr.repository.IFlatAddressRepository;
import com.ofr.repository.IFlatRepository;
import com.ofr.service.IFlatService;
@Service
public  class FlatService implements IFlatService{ 
	
	@Autowired
	private IFlatRepository flatRepository;
	
	@Autowired
	private IFlatAddressRepository flatAddressRepository;
	
	public Flat addFlat(Flat flat) {
		flatRepository.saveAndFlush(flat);
		return flat;
		}
	 
	public Flat updateFlat(Integer flatId,Flat flat1) throws FlatNotFoundException{
		Optional<Flat> flat=flatRepository.findById(flatId);
		if(flat.isPresent()) {
			Flat f1=flat.get();
			// Flat newFlat = new Flat();
	  f1.setCost(flat1.getCost());
	  f1.setAvailability(flat1.getAvailability());
	  
	  f1=flatRepository.save(f1);
		return f1;
		}
		return null;
		  
	}  
	
	public List<Flat> deleteFlat(Integer flatId) throws FlatNotFoundException{ 
		if(!flatRepository.existsById(flatId)) {
			throw new FlatNotFoundException();
		}
		flatRepository.deleteById(flatId);
		return flatRepository.findAll();
	}
	 public Flat viewFlat(Integer flatId) throws FlatNotFoundException{
		 if(!flatRepository.existsById(flatId)) {
		 throw new FlatNotFoundException();
		 }
		
	   return flatRepository.findById(flatId).get();
	 }
	 public List<Flat> viewAllFlat(){
		 return flatRepository.findAll();
	 }

	

	

   /*	public List<Flat> viewAllFlatByAddressAndAvailability(FlatAddress flatAddress, String availability) throws FlatNotFoundException {
		if(!flatRepository.existsByFlatAddress(flatAddress)) {
			 throw new FlatNotFoundException();
			 }
		 return flatRepository.viewAllFlatByAddressAndAvailability(flatAddress,availability);
	}  */

	

	


	

	

		
	
	
		
		
		 
		
		 
}


/*public Flat addFlat(Flat flat);
public Flat updateFlat(Flat flat) throws FlatNotFoundException;
public Flat deleteFlat(Flat flat) throws FlatNotFoundException;
public Flat viewFlat(int id) throws FlatNotFoundException;
public List<Flat> viewAllFlat();
public List<Flat> viewAllFlatByCost(float cost,String availability);
*/
	 
