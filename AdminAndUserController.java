package com.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofr.entities.Flat;
import com.ofr.entities.FlatAddress;
import com.ofr.entities.FlatBooking;
import com.ofr.entities.Landlord;
import com.ofr.entities.Tenant;
import com.ofr.exception.FlatBookingNotFoundException;
import com.ofr.exception.FlatNotFoundException;
import com.ofr.exception.LandlordNotFoundException;
import com.ofr.exception.TenantNotFoundException;
import com.ofr.serviceimpl.FlatBookingService;
import com.ofr.serviceimpl.FlatService;
import com.ofr.serviceimpl.LandlordService;
import com.ofr.serviceimpl.TenantService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin_user")
public class AdminAndUserController {

    

    @Autowired
    private FlatBookingService iflatbookingService;

    @Autowired
    private FlatService flatService;

    @Autowired
    private TenantService itenantService;

    @Autowired
    private LandlordService ilandlordService;

    @GetMapping("/viewTenantById/{tenant_id}")
    public Tenant viewTenantById(@PathVariable("tenant_id") int tenant_id) throws TenantNotFoundException {
        return itenantService.viewTenant(tenant_id);
    }
    @GetMapping("/viewAllTenant")
    public List<Tenant> viewAllTenant() {
        return itenantService.viewAllTenant();
    }

    @GetMapping("/viewAllFlat")
    public List<Flat>viewAllFlat(){
        return flatService.viewAllFlat();
    }

     @GetMapping("/getAllFlatBooking")
     public List<FlatBooking> getAllFlatBooking() {

         return iflatbookingService.getAllFlatBooking();
     }

      
        @GetMapping("/getLandlordById/{landlordId}")
        public Landlord getLandlordById(@PathVariable("landlordId") Integer landlordId) throws LandlordNotFoundException{
            return ilandlordService.getLandlord(landlordId);

        }

        @GetMapping("/getAllLandlord")
        public List<Landlord> getAllLandlord(){
         return ilandlordService.getAllLandlord();
        }








}