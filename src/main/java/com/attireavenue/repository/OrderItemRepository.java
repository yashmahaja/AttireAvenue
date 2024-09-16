package com.attireavenue.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.attireavenue.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
