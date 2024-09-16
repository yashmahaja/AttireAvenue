package com.attireavenu.service;

import com.attireavenu.exception.ProductException;
import com.attireavenu.modal.Cart;
import com.attireavenu.modal.CartItem;
import com.attireavenu.modal.User;
import com.attireavenu.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public CartItem addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
