package com.ofr.service;



import com.ofr.entities.Admin;
import com.ofr.exception.AdminNotFoundException;

public interface IAdminService {

    public Admin addAdmin(Admin admin);

    public String adminLogin(String adminUserName, String adminPassword)  throws AdminNotFoundException;

}
