package com.attireavenue.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	private String title;
	

	private String description;
	
	
	@Column(name="price")
	private int price;
	
	@Column(name="discounted_price")
	private int discountedPrice;
	
	@Column(name="discount_percent")
	private int discountPercent;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="brand")
	private int brand;
	
	@Column(name="color")
	private int color;
	
	
	@Embedded
	@ElementCollection
	@Column(name="sizes")
	private Set<Size> sizes = new HashSet<>();
	
	@Column(name="image_url")
	private int ImageUrl;
	
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Rating> ratings = new ArrayList<>();
	
	
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Review> reviews = new ArrayList<>();
	
	@Column(name="num_ratings")
	private int numRatings;
	
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	
	private LocalDateTime createdAt;
	
	public Product() {
		
	}

	public Product(Long id, String title, String description, int price, int discountedPrice, int discountPercent,
			int quantity, int brand, int color, Set<Size> sizes, int imageUrl, List<Rating> ratings,
			List<Review> reviews, int numRatings, Category category, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.discountPercent = discountPercent;
		this.quantity = quantity;
		this.brand = brand;
		this.color = color;
		this.sizes = sizes;
		ImageUrl = imageUrl;
		this.ratings = ratings;
		this.reviews = reviews;
		this.numRatings = numRatings;
		this.category = category;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Set<Size> getSizes() {
		return sizes;
	}

	public void setSizes(Set<Size> sizes) {
		this.sizes = sizes;
	}

	public int getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(int imageUrl) {
		ImageUrl = imageUrl;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getNumRatings() {
		return numRatings;
	}

	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	

}
