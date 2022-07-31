package com.ofr.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ofr.entities.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin,Integer> {
 public Admin findByAdminUserNameAndAdminPassword(String adminUserName, String adminPassword);
}

