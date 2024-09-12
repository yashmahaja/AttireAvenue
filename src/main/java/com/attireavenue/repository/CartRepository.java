package com.attireavenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attireavenue.model.Cart;

public interface CartRepository  extends JpaRepository<Cart,Long> {

}
