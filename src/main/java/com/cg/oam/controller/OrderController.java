package com.cg.oam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.entity.Order;

import com.cg.oam.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/getallorder")
	public List<Order> getOrder() {
		List<Order> allOrderList = (List<Order>) orderService.getAllOrders();
		return allOrderList;
	}

	@GetMapping("/getorderbyid/{id}")
	public ResponseEntity<Order> getOrderByid(@PathVariable("id") int id) {
		Order order = orderService.getOrderById(id);
		if (order == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(order));
	}
	
	@PostMapping( "/addorder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {

		Order o = orderService.addOrder(order);
		if (o != null) {
			return new ResponseEntity<Order>(o, HttpStatus.CREATED);

		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteOrderById(@PathVariable("id") int orderId) {

		ResponseEntity<Object> responseEntity = null;
		orderService.deleteOrderById(orderId);
		responseEntity = new ResponseEntity<>("Order data deleted successfully", HttpStatus.OK);
		return responseEntity;
	}
	@PutMapping("/updateorder")
	public ResponseEntity<?> updateOrder(@RequestBody Order order) {

		ResponseEntity<Object> responseEntity = null;
		Order updateOrder = orderService.updateOrder(order);
		responseEntity = new ResponseEntity<>(updateOrder, HttpStatus.OK);
		return responseEntity;
	}

}