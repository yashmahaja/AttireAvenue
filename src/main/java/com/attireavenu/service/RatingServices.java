package com.attireavenu.service;

import java.util.List;

import com.attireavenu.exception.ProductException;
import com.attireavenu.modal.Rating;
import com.attireavenu.modal.User;
import com.attireavenu.request.RatingRequest;

public interface RatingServices {
	
	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
