package com.ofr.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofr.entities.Flat;
import com.ofr.entities.Landlord;
import com.ofr.entities.User;
import com.ofr.exception.LandlordNotFoundException;
import com.ofr.exception.UserNotFoundException;
import com.ofr.repository.ILandlordRepository;
import com.ofr.repository.IUserRepository;
import com.ofr.service.ILandlordService;


@Service
public class LandlordService implements ILandlordService  {
	
	@Autowired
	private ILandlordRepository landlordRepository;
	@Autowired
	private IUserRepository userRepository;
	

	public Landlord addLandlord(Landlord landlord) {
        User user=landlord.getUser();
        try {
            user =userRepository.findById(user.getUserId()).orElseThrow(UserNotFoundException::new);
            landlord.setUser(user);
            System.out.println("user set for landlord *******");
        } catch (UserNotFoundException e) {

              e.printStackTrace();
        }
      landlordRepository.save(landlord);
      return landlord;
    }



    public Landlord updateLandlord(Integer landlordId, Landlord landlord1) throws LandlordNotFoundException{
        Optional<Landlord> landlord=landlordRepository.findById(landlordId);

         if (landlord.isPresent()) {
                Landlord ld = landlord.get();

               // Landlord newLandlord=new Landlord();
                ld.setLandlordName(landlord1.getLandlordName());
                ld.setLandlordAge(landlord1.getLandlordAge());
                ld.setFlatList(landlord1.getFlatList());

                ld=landlordRepository.save(ld);
                return landlord1;
         }
         return null;
    }


	public List<Landlord> deleteLandlord(Integer landlordId)throws LandlordNotFoundException{
		if(!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException();
		}
		landlordRepository.deleteById(landlordId);
		return landlordRepository.findAll();
	
	}


	public Landlord getLandlord(Integer landlordId) throws LandlordNotFoundException{

	if(!landlordRepository.existsById(landlordId)) {
		throw new LandlordNotFoundException();
	}
	return landlordRepository.findById(landlordId).get();
	}


	public List<Landlord> getAllLandlord(){
		return landlordRepository.findAll();
		}



	
}





	/*
	 * public Landlord updateLandlord(Landlord landlord) throws
	 * LandlordNotFoundException; public Landlord deleteLandlord(Landlord landlord)
	 * throws LandlordNotFoundException; public Landlord viewLandlord(int id) throws
	 * LandlordNotFoundException; public List<Landlord> viewAllLandlord();
	 */

