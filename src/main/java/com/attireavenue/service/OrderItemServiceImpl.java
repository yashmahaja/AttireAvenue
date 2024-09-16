package com.attireavenue.service;


import org.springframework.stereotype.Service;

import com.attireavenue.model.OrderItem;
import com.attireavenue.repository.OrderItemRepository;


@Service
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemRepository orderItemRepository;
	public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
		this.orderItemRepository=orderItemRepository;
	}
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		
		return orderItemRepository.save(orderItem);
	}


}
