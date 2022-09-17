package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Customer;
import com.cg.oam.entity.Medicine;
import com.cg.oam.exception.CustomerNotFoundException;
import com.cg.oam.exception.MedicineNotFoundException;
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
		Customer newCustomer = customerRepository.save(customer);
			return newCustomer;
		}

	

	public Customer getCustomerById(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty())
			throw new CustomerNotFoundException("Customer Not found with id : " + customerId);
		Customer customer = optionalCustomer.get();
		return customer;
	}
	

	public Customer getCustomerByName(String name) {
		
		Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepository.findByCustomerName(name));
		if (optionalCustomer.isEmpty())
			throw new CustomerNotFoundException("Customer Not found with Name : " + name);
		Customer customer = optionalCustomer.get();
		return customer;
	}


	public void deleteCustomerById(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not existing with id: "+customerId);
		}
		customerRepository.deleteById(customerId);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("No Customer with this id:"+customer.getCustomerId());
		}
		Customer updatedCustomer= customerRepository.save(customer);
		return updatedCustomer;
	}
	}
	
    


