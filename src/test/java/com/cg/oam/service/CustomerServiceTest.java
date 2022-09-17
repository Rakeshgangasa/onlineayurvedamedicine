package com.cg.oam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.entity.Customer;
import com.cg.oam.exception.CustomerNotFoundException;
import com.cg.oam.repository.CustomerRepository;

@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

	@Mock
	CustomerRepository customerRepository;

	@Test
	public void testGetCustomerById() {

		Customer customer = new Customer();
		customer.setCustomerId(111); 
		customer.setCustomerName("Farru");
		customer.setEmail("farru@gmail.com");
		customer.setMobileNo("5678904321");
		customer.setAddress("Karnataka");

		Optional<Customer> optionalCustomer = Optional.of(customer);

		when(customerRepository.findById(111)).thenReturn(optionalCustomer);

		Customer customerObj = customerServiceImpl.getCustomerById(111);

		assertEquals("Farru", customerObj.getCustomerName());
		assertEquals("farru@gmail.com", customerObj.getEmail());
	}

	@Test
	public void testGetCustomerByIdException() {

		when(customerRepository.findById(111)).thenThrow(CustomerNotFoundException.class);

		assertThrows(CustomerNotFoundException.class, () -> customerServiceImpl.getCustomerById(111));
	}

	@Test
	public void testGetAllCustomers() {

		Customer customer = new Customer();
		customer.setCustomerId(111);
		customer.setCustomerName("Farru");
		customer.setEmail("farru@gmail.com");
		customer.setMobileNo("5678904321");
		customer.setAddress("Karnataka");

		Customer customer2 = new Customer();
		customer2.setCustomerId(112);
		customer2.setCustomerName("gayathri");
		customer2.setEmail("gayathri@gmail.com");
		customer2.setMobileNo("5678994321");
		customer2.setAddress("vijayawada");

		Customer customer3 = new Customer();
		customer3.setCustomerId(113);
		customer3.setCustomerName("kavana");
		customer3.setEmail("kavana@gmail.com");
		customer3.setMobileNo("5678904321");
		customer3.setAddress("Karnataka");

		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer3);
		customerList.add(customer2);
		customerList.add(customer);

		when(customerRepository.findAll()).thenReturn(customerList);

		List<Customer> customers = customerServiceImpl.getAllCustomers();

		assertEquals(3, customers.size());
	}

	/*
	 * @Test public void testDeleteCustomer() {
	 * 
	 * Customer customer = new Customer(); customer.setCustomerId(111);
	 * customer.setCustomerName("Farru"); customer.setEmail("farru@gmail.com");
	 * customer.setMobileNo("5678904321"); customer.setAddress("Karnataka");
	 * 
	 * Optional<Customer> optionalCustomer = Optional.of(customer);
	 * 
	 * when(customerRepository.findById(111)).thenReturn(optionalCustomer);
	 * 
	 * doNothing().when(customerRepository).deleteById(111);
	 * 
	 * customerServiceImpl.deleteCustomerById(111);
	 * 
	 * verify(customerRepository, times(1)).findById(111);
	 * verify(customerRepository, times(1)).deleteById(111); }
	 */

}

