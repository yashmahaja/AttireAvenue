package com.attireavenue.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attireavenue.model.Cart;
import com.attireavenue.model.CartItem;
import com.attireavenue.model.User;
import com.attireavenue.requests.AddItemRequest;
import com.attireavenue.response.ApiResponse;
import com.attireavenue.service.CartService;
import com.attireavenue.service.UserService;
import com.attireavenue.exception.ProductException;
import com.attireavenue.exception.UserException;


@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	private CartService cartService;
	private UserService userService;
	
	public CartController(CartService cartService,UserService userService) {
		this.cartService=cartService;
		this.userService=userService;
	}
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws UserException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		Cart cart=cartService.findUserCart(user.getId());
		
		System.out.println("cart - "+cart.getUser().getEmail());
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/add")
	public ResponseEntity<CartItem> addItemToCart(@RequestBody AddItemRequest req, 
			@RequestHeader("Authorization") String jwt) throws UserException, ProductException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		CartItem item = cartService.addCardItem(user.getId(), req);
		
		ApiResponse res= new ApiResponse("Item Added To Cart Successfully",true);
		
		return new ResponseEntity<>(item,HttpStatus.ACCEPTED);
		
	}
	

}

