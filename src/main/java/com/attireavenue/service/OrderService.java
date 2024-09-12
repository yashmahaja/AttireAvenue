package com.attireavenue.service;

import java.util.List;

import com.attireavenue.exception.OrderException;
import com.attireavenue.model.Address;
import com.attireavenue.model.Order;
import com.attireavenue.model.User;

public interface OrderService {
	
	public Order createOrder(User user, Address shippingAddress);
	public Order findOrderById(Long orderId) throws OrderException;
	
	public List<Order> usersOrderHistory(Long userId);
	
	public Order placedOrder(Long orderId) throws OrderException;
	public Order confirmOrder(Long orderId) throws OrderException;
	public Order shippedOrder(Long orderId) throws OrderException;
	public Order deliveredOrder(Long orderId) throws OrderException;
	public Order cancelledOrder(Long orderId) throws OrderException;
	public List<Order> getAllOrder();
	
	public void deleteOrder(Long orderId) throws OrderException;

}
