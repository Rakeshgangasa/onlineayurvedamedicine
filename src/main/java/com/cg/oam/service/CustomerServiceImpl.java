package com.cg.oam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Customer;

import com.cg.oam.exception.CustomerNotFoundException;
import com.cg.oam.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub

		return customerRepository.save(customer);

	}

	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();

	}

	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerName(name);

	}

	public void deleteCustomerById(int customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer != null) {
			customerRepository.delete(customer);
		} else {
			throw new CustomerNotFoundException("Customer not found");
		}

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updateCustomer = getCustomerById(customer.getCustomerId());
		updateCustomer = customerRepository.save(customer);
		return updateCustomer;
	}
    
 }

