package com.cg.oam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Customer;
import com.cg.oam.repository.CustomerRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

	@Service
	public class CustomerServiceImpl implements CustomerService {

		@Autowired
		private CustomerRepository customerRepository;
		
		@Override
		public Customer customerLogin(String username, String password) {
			
			Customer customer = customerRepository.doCustomerLogin(username, password);
			
			if(customer == null) {
				throw new AuthenticationFailureException("Username or password is incorrect");
			}
			
			return customer;
		}

		@Override
		public Customer saveCustomer(Customer customer) {
			Customer savedCustomer = customerRepository.save(customer);
			return savedCustomer;
		}

		@Override
		public Customer getCustomerById(int customerId) {
			Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
			if (optionalCustomer.isEmpty())
				throw new ResourceNotFoundException("Customer Not found with id : " + customerId);
			Customer customer = optionalCustomer.get();
			return customer;
		}

		@Override
		public List<Customer> getAllCustomers() {
			List<Customer> customers = customerRepository.findAll();
			return customers;
		}

		@Override
		public Customer updateCustomer(Customer customer) {
			Customer updateCustomer = getCustomerById(customer.getCustomerId());
			updateCustomer = customerRepository.save(customer);
			return updateCustomer;
		}

		@Override
		public void deleteCustomerById(int customerId) {
			Customer customer = getCustomerById(customerId);
			customerRepository.delete(customer);
		}

	}

