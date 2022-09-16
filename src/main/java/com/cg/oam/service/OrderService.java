package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.Customer;
import com.cg.oam.entity.Order;

public interface OrderService {

	public List<Order> getAllOrders();

	public Order addOrder(Order order);

	public Order getOrderById(int id);

	public void deleteOrderById(int orderId);

	Order updateOrder(Order rder);
	
	
}
