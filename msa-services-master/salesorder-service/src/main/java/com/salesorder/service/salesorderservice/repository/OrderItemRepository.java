package com.salesorder.service.salesorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesorder.service.salesorderservice.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
