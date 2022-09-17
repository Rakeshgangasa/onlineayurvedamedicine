package com.cg.oam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

}
