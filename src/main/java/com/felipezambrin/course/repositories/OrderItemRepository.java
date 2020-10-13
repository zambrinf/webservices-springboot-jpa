package com.felipezambrin.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipezambrin.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { 
	
}
