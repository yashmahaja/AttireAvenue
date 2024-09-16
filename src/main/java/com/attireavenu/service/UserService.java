package com.attireavenu.service;

import java.util.List;

import com.attireavenu.exception.UserException;
import com.attireavenu.modal.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public List<User> findAllUsers();

}
