package com.attireavenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attireavenu.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
