package com.ofr.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="tenant_2")
public class Tenant {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int tenant_id;

    @Column
    private int tenant_age;

    @Column
    private String tenantName;



    @OneToOne
    private User user;

    public Tenant() {}

    public Tenant( int tenant_age, String tenantName, User user) {
        super();

        this.tenant_age = tenant_age;
        this.tenantName = tenantName;

        this.user = user;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    

    public int getTenant_age() {
        return tenant_age;
    }

    public void setTenant_age(int tenant_age) {
        this.tenant_age = tenant_age;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tenant [tenant_id=" + tenant_id + ", tenant_age=" + tenant_age + ", tenantName=" + tenantName
                +  ", user=" + user + "]";
    }

}