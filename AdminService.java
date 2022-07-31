package com.ofr.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofr.entities.Admin;
import com.ofr.entities.Flat;
import com.ofr.exception.AdminNotFoundException;
import com.ofr.repository.IAdminRepository;
import com.ofr.repository.IFlatRepository;
import com.ofr.service.IAdminService;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository;

    public Admin addAdmin(Admin admin) {
        adminRepository.saveAndFlush(admin);
        return admin;
    }

    public String adminLogin(String adminUserName, String adminPassword) throws AdminNotFoundException {
        if(adminRepository.findByAdminUserNameAndAdminPassword(adminUserName, adminPassword)!=null) {
            return "Login Successfull";
        }
        throw new AdminNotFoundException();
    }
}