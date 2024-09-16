package com.attireavenue.service;

import com.attireavenue.exception.ProductException;
import com.attireavenue.model.Cart;
import com.attireavenue.model.CartItem;
import com.attireavenue.model.User;
import com.attireavenue.requests.AddItemRequest;

public interface CartService {

	
	public Cart createCart(User user);
	
	public CartItem addCardItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);
	

	
}
