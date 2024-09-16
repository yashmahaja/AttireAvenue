package com.attireavenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attireavenue.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
