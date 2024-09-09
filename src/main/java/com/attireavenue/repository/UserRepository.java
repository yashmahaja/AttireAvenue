package com.attireavenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attireavenue.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByEmail(String email);

}
