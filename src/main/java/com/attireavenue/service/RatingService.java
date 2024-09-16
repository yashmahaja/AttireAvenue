package com.attireavenue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attireavenue.exception.ProductException;
import com.attireavenue.model.Rating;
import com.attireavenue.model.User;
import com.attireavenue.requests.RatingRequest;

@Service
public interface RatingService {
	public Rating createRating(RatingRequest req, User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);
	

}
