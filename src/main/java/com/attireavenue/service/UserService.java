package com.attireavenue.service;

import java.util.List;

import com.attireavenue.exception.UserException;
import com.attireavenue.model.User;

public interface UserService {
	
	
	
	public User findUserByLongId(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	public List<User> findAllUsers();

}
