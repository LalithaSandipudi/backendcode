package com.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ofr.entities.User;
import com.ofr.exception.FlatBookingNotFoundException;
import com.ofr.exception.FlatNotFoundException;
import com.ofr.exception.UserNotFoundException;
import com.ofr.service.IFlatService;
import com.ofr.serviceimpl.FlatBookingService;
import com.ofr.serviceimpl.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService iuserservice;

    @Autowired
    private FlatBookingService iflatbookingService;

    @Autowired
    private IFlatService iflatService;

    
    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId,@RequestBody User user1 ) throws UserNotFoundException{
        return iuserservice.updateUser(userId,user1);

    }


     @PostMapping("/addFlat")
    public Flat addFlat(@RequestBody Flat flat) {
        return iflatService.addFlat(flat);
    }


      @GetMapping("/getFlatBooking/{bookingNo}")

        public FlatBooking getFlatBooking(@PathVariable("bookingNo") Integer bookingNo)throws FlatBookingNotFoundException
         {
           return iflatbookingService.getFlatBooking(bookingNo);
           }

       
    @DeleteMapping("/deleteFlatBooking/{bookingNo}")

   public List<FlatBooking> deleteFlatBooking(@PathVariable("bookingNo") Integer bookingNo)throws FlatBookingNotFoundException
    {
      return iflatbookingService.deleteFlatBooking(bookingNo);
      }

    @PutMapping("/updateFlatBooking/{bookingNo}")

    public FlatBooking updateFlatBooking(@PathVariable("bookingNo") Integer bookingNo,@RequestBody FlatBooking flatbooking1)throws FlatBookingNotFoundException
     {
       return iflatbookingService.updateFlatBooking(bookingNo, flatbooking1);

      }

    @GetMapping("/viewFlatById/{flatId}")
    public Flat viewFlatById(@PathVariable("flatId")Integer flatId)throws FlatNotFoundException {
        return iflatService.viewFlat(flatId);
    }

    @PostMapping("/addFlatBooking")
    public FlatBooking addFlatBooking(@RequestBody FlatBooking flatbooking){

        return iflatbookingService.addFlatBooking(flatbooking);
    }


    @DeleteMapping("/deleteUser/{userId}")
    public User deleteUser(@PathVariable("userId")int userId) throws UserNotFoundException {

    return iuserservice.deleteUser(userId);


}
}