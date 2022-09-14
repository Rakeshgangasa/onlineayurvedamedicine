package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.Customer;

public interface CustomerService {

	public Customer customerLogin(String username, String password);
	public Customer saveCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public List<Customer> getAllCustomers();
	public Customer updateCustomer(Customer customer);
	public void deleteCustomerById(int customerId);

}
