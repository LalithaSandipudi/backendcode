package com.ofr.service;

import java.util.List;

import com.ofr.entities.User;
import com.ofr.exception.UserNotFoundException;

public interface IUserService {

	public User addUser(User user);

    public User updateUser(Integer userId,User user1) throws UserNotFoundException;

    public User viewUser(int userId) throws UserNotFoundException;

    public List<User> viewAllUser();

    public User deleteUser(int userId) throws UserNotFoundException ;
    public String userLogin(String userName, String password) ;

}
