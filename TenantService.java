package com.ofr.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofr.entities.Tenant;
import com.ofr.entities.User;
import com.ofr.exception.TenantNotFoundException;
import com.ofr.repository.ITenantRepository;
import com.ofr.repository.IUserRepository;
import com.ofr.service.ITenantService;

@Service
public class TenantService implements ITenantService  {
	@Autowired
    private ITenantRepository tenantRepository;

    @Autowired
    private IUserRepository userRepository;

    public Tenant addTenant(Tenant tenant) {
    User user=tenant.getUser();
            try {
                user =userRepository.findById(user.getUserId()).orElseThrow(TenantNotFoundException::new);
                tenant.setUser(user);
                System.out.println("user set for tenant ***");
            } catch (TenantNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            tenantRepository.saveAndFlush(tenant);
            System.out.println("user set for tenant ***"+tenant); 
            return tenant;
        }



    public Tenant updateTenant(Integer tenant_id, Tenant tenant1) throws TenantNotFoundException{
             Optional<Tenant>tenant=tenantRepository.findById(tenant_id); 
               if (tenant.isPresent()) {
               Tenant t1=tenant.get();
               t1.setTenant_age(t1.getTenant_age());
               t1.setTenantName(t1.getTenantName());
               t1=tenantRepository.save(t1);
                       return t1;
                  }
               return null;
    }  

    public List<Tenant> deleteTenant(Integer tenant_id) throws TenantNotFoundException{ 
        if(!tenantRepository.existsById(tenant_id)) {
            throw new TenantNotFoundException();
        }
        tenantRepository.deleteById(tenant_id);
        return tenantRepository.findAll();
    }

    public Tenant viewTenant(Integer tenant_Id) throws TenantNotFoundException{
         if(!tenantRepository.existsById(tenant_Id)) {
         throw new TenantNotFoundException();
         }

       return tenantRepository.findById(tenant_Id).get();
     }


    public List<Tenant> viewAllTenant(){
        return tenantRepository.findAll();
    }





}