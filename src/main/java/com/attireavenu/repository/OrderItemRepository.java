package com.attireavenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attireavenu.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
