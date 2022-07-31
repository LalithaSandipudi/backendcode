package com.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ofr.entities.User;


public interface IUserRepository extends JpaRepository<User,Integer>{

	public User findByUserNameAndPassword(String userName, String password);

    


}