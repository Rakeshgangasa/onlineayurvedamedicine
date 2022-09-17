package com.cg.oam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.cg.oam.entity.Order;
import com.cg.oam.exception.OrderNotFoundException;
import com.cg.oam.repository.OrderRepository;
 
@SpringBootTest
public class OrderServiceTest {

    @InjectMocks
    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    @Mock
    OrderRepository orderRepository;    

    @Test
    public void testGetOrderById() {

        Order order = new Order();
        order.setOrderId(121);
        order.setOrderDate(LocalDate.of(2020, 11, 10));
        order.setDispatchDate(LocalDate.of(2020, 11, 20));
        order.setTotalCost(100);
       

        Optional<Order> optionalOrder = Optional.of(order);

        when(orderRepository.findById(121)).thenReturn(optionalOrder);

        Order orderObj = orderServiceImpl.getOrderById(121);

        assertEquals(121,orderObj.getOrderId()); 
        assertEquals(100,orderObj.getTotalCost());        
    }

    @Test
    public void testGetOrderByIdException() {

        when(orderRepository.findById(121)).thenThrow(OrderNotFoundException.class);

        assertThrows(OrderNotFoundException.class,()->orderServiceImpl.getOrderById(121));
    }

    @Test
    public void testGetAllOrders() {

    	Order order = new Order();
        order.setOrderId(121);
        order.setOrderDate(LocalDate.of(2020, 10, 10));
        order.setDispatchDate(LocalDate.of(2020, 10, 20));
        order.setTotalCost(10f);

        Order order2 = new Order();
        order.setOrderId(122);
        order.setOrderDate(LocalDate.of(2021, 10, 10));
        order.setDispatchDate(LocalDate.of(2021, 10, 30));
        order.setTotalCost(20f);

        Order order3 = new Order();
        order3.setOrderId(123);
        order3.setOrderDate(LocalDate.of(2020, 12, 10));
        order3.setDispatchDate(LocalDate.of(2020, 12, 11));
        order3.setTotalCost(30f);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order3);
        orderList.add(order2);
        orderList.add(order);

        when(orderRepository.findAll()).thenReturn(orderList);

        List<Order> orders = orderServiceImpl.getAllOrders();

        assertEquals(3, orders.size());
    }

	

}