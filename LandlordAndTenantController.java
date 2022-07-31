package com.ofr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofr.entities.Admin;
import com.ofr.entities.User;
import com.ofr.exception.AdminNotFoundException;
import com.ofr.service.IAdminService;
import com.ofr.service.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/LandlordAndTenant")
public class LandlordAndTenantController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@Valid @RequestBody  Admin admin) {
        return adminService.addAdmin(admin);
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody  User user) {
        return userService.addUser(user);
    }

    @GetMapping("/adminLogin/{adminUserName}/{adminPassword}")
    public String adminLogin(@PathVariable("adminUserName") String adminUserName,@PathVariable("adminPassword") String adminPassword) throws AdminNotFoundException {
        return adminService.adminLogin(adminUserName, adminPassword);
    }

    @GetMapping("/userLogin/{userName}/{password}")
    public String userLogin(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        return userService.userLogin(userName, password);
    }



}

