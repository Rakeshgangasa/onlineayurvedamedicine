package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Customer;
import com.cg.oam.entity.Order;

import com.cg.oam.exception.OrderNotFoundException;
import com.cg.oam.repository.CustomerRepository;
import com.cg.oam.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository  customerRepository; 
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		return orders;
	}

	@Override
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
				return orderRepository.findById(id).get();
	}

	@Override
	public void deleteOrderById(int orderId) {
		Order order = orderRepository.findByOrderId(orderId);
		if(order != null) {
			orderRepository.delete(order);
		}else {
			throw new OrderNotFoundException("Order not found");
		}
		
	}
		

	@Override
	public Order updateOrder(Order order) {
		Order updateOrder = getOrderById(order.getOrderId());
		updateOrder = orderRepository.save(order);
		return updateOrder;
	}

	

}
