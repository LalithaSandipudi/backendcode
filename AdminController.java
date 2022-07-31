package com.ofr.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofr.entities.Flat;
import com.ofr.entities.FlatBooking;
import com.ofr.entities.Landlord;
import com.ofr.entities.Tenant;
import com.ofr.entities.User;
import com.ofr.exception.FlatBookingNotFoundException;
import com.ofr.exception.FlatNotFoundException;
import com.ofr.exception.LandlordNotFoundException;
import com.ofr.exception.TenantNotFoundException;
import com.ofr.exception.UserNotFoundException;
import com.ofr.serviceimpl.FlatBookingService;
import com.ofr.serviceimpl.LandlordService;
import com.ofr.serviceimpl.TenantService;
import com.ofr.serviceimpl.UserService;
import com.ofr.service.IFlatService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Admin")
public class AdminController {

    
    @Autowired
    private LandlordService ilandlordservice;

    @Autowired
    private TenantService itenantservice;

    @Autowired
    private FlatBookingService iflatbookingService;

    @Autowired
    private IFlatService iflatService;

    @Autowired
    private TenantService itenantService;

    @Autowired
    private UserService iuserService;

     @PostMapping ("/addLandlord")
      public Landlord addLandlord(@RequestBody Landlord landlord ) 
      { System.out.println("request received "+ landlord);

      return ilandlordservice.addLandlord(landlord); }

      @PostMapping("/addTenant")
        public Tenant addTenant(@RequestBody Tenant tenant) {
            return itenantservice.addTenant(tenant);
        }

      @PutMapping("/updatelandlord/{landlordId}")
        public Landlord updateLandlord(@PathVariable("landlordId") Integer landlordId,@RequestBody Landlord landlord1 ) throws LandlordNotFoundException{
            return ilandlordservice.updateLandlord(landlordId, landlord1);

        }

        @PutMapping("/updateTenant/{tenant_id}")
        public Tenant updateTenant(@PathVariable("tenant_id") int tenant_id,@RequestBody Tenant tenant1) throws TenantNotFoundException {
            return itenantservice.updateTenant(tenant_id,tenant1);
        }


    @GetMapping("/viewUser/{id}")
    public User viewUser(@PathVariable("id") Integer userId) throws UserNotFoundException{
        return iuserService.viewUser(userId);

    }

    @GetMapping("/viewAllUser")
    public List<User> viewAllUser(){
     return iuserService.viewAllUser();
    }


    @DeleteMapping("/deleteLandlord/{landlordId}")
    public List<Landlord> deleteLandlord(@PathVariable ("landlordId") Integer landlordId) throws LandlordNotFoundException{
        return ilandlordservice.deleteLandlord(landlordId);
    }


    @DeleteMapping("/deleteTenant/{tenant_id}")
    public List<Tenant>  deleteTenant(@PathVariable("tenant_id") int tenant_id) throws TenantNotFoundException {
        return itenantservice.deleteTenant(tenant_id);
    }


     @PutMapping("/updateFlat/{flatId}")
     public Flat updateFlat(@PathVariable("flatId")Integer flatId,@RequestBody Flat flat1) throws FlatNotFoundException{

     return iflatService.updateFlat(flatId, flat1);
 }

     
     @DeleteMapping("/deleteFlat/{flatId}")
        public List<Flat>deleteFlat(@PathVariable("flatId")Integer flatId)throws FlatNotFoundException{

            return iflatService.deleteFlat(flatId);
        }

    


}