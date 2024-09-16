package com.attireavenue.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.attireavenue.exception.CartItemException;
import com.attireavenue.exception.UserException;
import com.attireavenue.model.Cart;
import com.attireavenue.model.CartItem;
import com.attireavenue.model.Product;
import com.attireavenue.model.User;
import com.attireavenue.repository.CartItemRepository;
import com.attireavenue.repository.CartRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

	
	private CartItemRepository cartItemRepository;
	private UserService userService;
	private CartRepository cartRepository;
	
	public CartItemServiceImpl(CartItemRepository cartItemRepository, UserService userService, CartRepository cartRepository) {
		this.cartItemRepository= cartItemRepository;
		this.userService = userService;
		this.cartRepository = cartRepository;
	}
	@Override
	public CartItem createCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());
		
		CartItem createdCartItem = cartItemRepository.save(cartItem);
		return createdCartItem;
	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {

		CartItem item = findCartItemById(id);
		User user = userService.findUserByLongId(item.getUserId());
		
		if(user.getId().equals(userId)) {
			item.setQuantity(cartItem.getQuantity());
			item.setPrice(item.getQuantity()*item.getProduct().getPrice());
			item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());
		}
		return cartItemRepository.save(item);
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
		
		CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);
		return cartItem;
	}

	@Override
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
		
		CartItem cartItem = findCartItemById(cartItemId);
		User user = userService.findUserByLongId(cartItem.getUserId());
		User reqUser = userService.findUserByLongId(userId);
		if(user.getId().equals(reqUser.getId())){
			cartItemRepository.deleteById(cartItemId);
		}
		
		else {
			throw new UserException("You can't remove another user's items");
		}
	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {
		Optional<CartItem> opt = cartItemRepository.findById(cartItemId);		
		
		if(opt.isPresent()) {
			return opt.get();
			
		}
				throw new CartItemException("CartItem not found with id: "+ cartItemId);
	}

}
