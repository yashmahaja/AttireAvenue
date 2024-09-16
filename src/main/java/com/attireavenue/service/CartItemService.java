package com.attireavenue.service;

import com.attireavenue.exception.CartItemException;
import com.attireavenue.exception.UserException;
import com.attireavenue.model.Cart;
import com.attireavenue.model.CartItem;
import com.attireavenue.model.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException,UserException;
	
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
	
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;

}
