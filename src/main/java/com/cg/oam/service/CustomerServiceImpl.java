package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Customer;

import com.cg.oam.exception.AuthenticationFailureException;
import com.cg.oam.exception.CustomerNotFoundException;
import com.cg.oam.exception.ResourceNotFoundException;
import com.cg.oam.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer is not existing with id: " + customerId);
		}

		return optionalCustomer.get();
	}

	@Override
	public Customer customerLogin(String username, String password) {

		Optional<Customer> optionalCustomer = customerRepository.findByUsername(username);

		if (optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Username is not existing.");
		}

		Customer customer = optionalCustomer.get();

		if (!password.equals(customer.getPassword())) {

			throw new AuthenticationFailureException("Invalid Password.");
		}

		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
		if (optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("No Customer with this id:" + customer.getId());
		}
		return customerRepository.save(customer);
	}
	@Override
	public void deleteCustomer(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not existing with id: " + customerId);
		}
		customerRepository.deleteById(customerId);

	}
	@Override
    public Customer validateCustomerByEmail(String emailId) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailId(emailId);
        if(optionalCustomer.isEmpty())  {
            throw new CustomerNotFoundException("Customer not existing with email: ");
            
        }
        return optionalCustomer.get();
    
    }
}
