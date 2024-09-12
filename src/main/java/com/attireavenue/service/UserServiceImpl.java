package com.attireavenue.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.attireavenue.config.JwtProvider;
import com.attireavenue.exception.UserException;
import com.attireavenue.model.User;
import com.attireavenue.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	
	public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
	}
	
	@Override
	public User findUserByLongId(Long userId) throws UserException {
		Optional <User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserException("user not found with id: " + userId);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		
		String email = jwtProvider.getEmailFromToken(jwt);
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new UserException("user not found with email");
		}
		return null;
	}

}
