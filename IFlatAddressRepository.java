package com.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofr.entities.FlatAddress;

public interface IFlatAddressRepository extends JpaRepository<FlatAddress, Integer>{

}
