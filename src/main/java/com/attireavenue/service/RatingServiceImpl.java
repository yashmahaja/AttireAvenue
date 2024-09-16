package com.attireavenue.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.attireavenue.exception.ProductException;
import com.attireavenue.model.Product;
import com.attireavenue.model.Rating;
import com.attireavenue.model.User;
import com.attireavenue.repository.RatingRepository;
import com.attireavenue.requests.RatingRequest;

@Service
public class RatingServiceImpl implements RatingService{
	
	private RatingRepository ratingRepository;
	private ProductService productService;
	
	public RatingServiceImpl(RatingRepository ratingRepository, ProductService productService ){
		this.ratingRepository = ratingRepository;
		this.productService = productService;
	}
	@Override
	public Rating createRating(RatingRequest req, User user) throws ProductException {
		// TODO Auto-generated method stub
		Product product = productService.findProductById(req.getProductId());
		Rating rating = new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.getAllProductsRating(productId);
	}

}
