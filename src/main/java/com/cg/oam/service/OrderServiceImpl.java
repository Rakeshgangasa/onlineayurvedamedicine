package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Customer;
import com.cg.oam.entity.Order;
import com.cg.oam.exception.CustomerNotFoundException;
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
		return orderRepository.findAll();
	}

	@Override
	public Order addOrder(Order order) {
		
		return orderRepository.save(order);
		}
	

	@Override
	public Order getOrderById(int id) {
       Optional<Order> optionalOrder = orderRepository.findById(id);
		
		if(optionalOrder.isEmpty()) {
			throw new OrderNotFoundException("Order not exising with id: "+id);
		}
		
		return optionalOrder.get();
	}
	

	@Override
	public void deleteOrderById(int orderId) {
     Optional<Order> optionalOrder = orderRepository.findById(orderId);
		
		if(optionalOrder.isEmpty()) {
			throw new OrderNotFoundException("Order not exising with id: "+orderId);
		}
		
		Order order = optionalOrder.get();
		
		orderRepository.delete(order);
		
	}
		

	@Override
	public Order updateOrder(Order order) {
     Optional<Order> optionalOrder= orderRepository.findById(order.getOrderId());
		
		if(optionalOrder.isEmpty()) {
			throw new OrderNotFoundException("Order not exising with id: "+order.getOrderId());
		}
		
		return orderRepository.save(order);
	}

	@Override
	public Customer getOrderByCustomerId(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty())
			throw new CustomerNotFoundException("Customer Not found with id : " + customerId);
		Customer customer = optionalCustomer.get();;
		return customer;
	}

	

}
