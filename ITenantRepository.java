package com.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofr.entities.Tenant;

@Repository
public interface ITenantRepository extends JpaRepository<Tenant,Integer> {

}
