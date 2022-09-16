package com.cg.oam.service;


import java.util.List;

import com.cg.oam.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer addCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public Customer getCustomerByName(String name);

	public void deleteCustomerById(int customerId);

	Customer updateCustomer(Customer customer);

}
