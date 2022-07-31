package com.ofr.service;

import java.util.List;

import com.ofr.entities.Tenant;
import com.ofr.exception.TenantNotFoundException;

public interface ITenantService {

	public Tenant addTenant(Tenant tenant) ;
	
	 public Tenant updateTenant(Integer tenant_id, Tenant tenant1) throws TenantNotFoundException;
	
	 public List<Tenant> deleteTenant(Integer tenant_id) throws TenantNotFoundException;
	
	 public Tenant viewTenant(Integer tenant_Id) throws TenantNotFoundException;
		 
	 public List<Tenant> viewAllTenant();
	
	
	
}
