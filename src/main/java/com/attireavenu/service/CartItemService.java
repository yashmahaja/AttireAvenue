package com.attireavenu.service;

import com.attireavenu.exception.CartItemException;
import com.attireavenu.exception.UserException;
import com.attireavenu.modal.Cart;
import com.attireavenu.modal.CartItem;
import com.attireavenu.modal.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id,CartItem cartItem) throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size, Long userId);
	
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}
