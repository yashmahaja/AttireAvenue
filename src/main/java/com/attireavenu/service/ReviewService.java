package com.attireavenu.service;

import java.util.List;

import com.attireavenu.exception.ProductException;
import com.attireavenu.modal.Review;
import com.attireavenu.modal.User;
import com.attireavenu.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}
