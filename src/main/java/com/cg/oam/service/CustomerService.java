package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.Customer;
import com.cg.oam.exception.CustomerNotFoundException;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);

	Customer customerLogin(String username, String password);

	Customer updateCustomer(Customer customer);

	public void deleteCustomer(int customerId);
	public Customer validateCustomerByEmail(String emailId) throws CustomerNotFoundException;

}
