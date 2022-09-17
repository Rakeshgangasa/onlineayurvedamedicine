package com.cg.oam.controller;

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
import com.cg.oam.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/getallcustomers")
	public List<Customer> getCustomers() {
		List<Customer> allCustomerList = (List<Customer>) customerService.getAllCustomers();
		return allCustomerList;
	}

	@GetMapping("/getCustomerbyid/{customerId}")
	public ResponseEntity<Object> fetchProductById(@PathVariable("customerId") int customerId) {
		//try {
		Customer customer = customerService.getCustomerById(customerId);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
		return responseEntity;
		//}
	/*	catch(ProductNotFoundException e) {
			ResponseEntity<Object> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			return responseEntity;
		}*/
	}

	@GetMapping("/getcustomerbyname/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name) {
		Customer customer = customerService.getCustomerByName(name);
		if (customer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customer));
	}

	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		ResponseEntity<Customer> responseEntity = null;
		Customer saveCustomer = customerService.addCustomer(customer);
		responseEntity = new ResponseEntity<>(saveCustomer, HttpStatus.CREATED);
		return responseEntity;
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") int customerId) {

		ResponseEntity<Object> responseEntity = null;
		customerService.deleteCustomerById(customerId);
		responseEntity = new ResponseEntity<>("Customer data deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/updatecustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {

		ResponseEntity<Object> responseEntity = null;
		Customer updateCustomer = customerService.updateCustomer(customer);
		responseEntity = new ResponseEntity<>(updateCustomer, HttpStatus.OK);
		return responseEntity;
	}

}
  
  