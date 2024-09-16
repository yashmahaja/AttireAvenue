package com.attireavenue.service;

import java.util.List;

import com.attireavenue.exception.ProductException;
import com.attireavenue.model.Review;
import com.attireavenue.model.User;
import com.attireavenue.requests.ReviewRequest;

public interface ReviewService {
	
	public Review createReview(ReviewRequest req, User user) throws ProductException;
	public List<Review> getAllReview(Long productId);
}
