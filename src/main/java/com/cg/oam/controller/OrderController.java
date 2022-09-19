package com.cg.oam.controller;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.cg.oam.entity.Customer;
import com.cg.oam.entity.Medicine;
import com.cg.oam.entity.Order;
import com.cg.oam.entity.OrderItem;
import com.cg.oam.model.OrderRequestPayload;
import com.cg.oam.service.CustomerService;
import com.cg.oam.service.MedicineService;
import com.cg.oam.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	CustomerService customerService;
	@Autowired
	MedicineService medicineService;
	
	@GetMapping("/getallorder")
	public List<Order> getOrder() {
		List<Order> allOrderList = (List<Order>) orderService.getAllOrders();
		return allOrderList;
	}
	@GetMapping("/getallorderById/{customerId}")
	public ResponseEntity<Customer> getOrderByCustomerId(@PathVariable("customerId") int customerId) {
		Customer customer = orderService.getOrderByCustomerId(customerId);
		if (customer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	@GetMapping("/getorderbyid/{orderId}")
	public ResponseEntity<Order> getOrderByid(@PathVariable("orderId") int orderId) {
		Order order = orderService.getOrderById(orderId);
		if (order == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(order));
	}
	
	@PostMapping( "/addorder")
	public ResponseEntity<Order> addOrder(@RequestBody OrderRequestPayload orderRequestPayload ) {
        int customerId=orderRequestPayload.getCustomerId();
        List<Integer> medicineIds=orderRequestPayload.getMedicines();
        List<OrderItem> orderItemList= new ArrayList<>();
        Order order=new Order();
       float totalAmount=0;
        medicineIds.forEach(m->{
        	Medicine medicine= medicineService.getMedicineById(m);
        	OrderItem orderItem =new OrderItem();
        	orderItem.setMedicine(medicine);
            orderItem.setCost(medicine.getMedicineCost());
            orderItem.setOrder(order);
        	orderItemList.add(orderItem);
        	//totalAmount=totalAmount+medicine.getMedicineCost();
        });
        for(OrderItem o:orderItemList) {
        	totalAmount=totalAmount+o.getCost();	
        }
        order.setOrderItems(orderItemList);
        Customer customer= customerService.getCustomerById(customerId);
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());
        order.setDispatchDate(LocalDate.now().plusDays(10));
        order.setTotalCost(totalAmount);	
		Order o = orderService.addOrder(order);
		if (o != null) {
			return new ResponseEntity<Order>(o, HttpStatus.CREATED);

		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<?> deleteOrderById(@PathVariable("orderId") int orderId) {

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