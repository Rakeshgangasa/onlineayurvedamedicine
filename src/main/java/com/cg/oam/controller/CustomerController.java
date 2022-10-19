package com.cg.oam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.entity.Customer;
import com.cg.oam.model.LoginRequest;
import com.cg.oam.model.LoginResponse;
import com.cg.oam.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PutMapping("/updatecustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		ResponseEntity<Object> responseEntity = null;
		Customer updateCustomer = customerService.updateCustomer(customer);
		responseEntity = new ResponseEntity<>(updateCustomer, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.addCustomer(customer);

		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> fetchCustomerById(@PathVariable("customerId") int customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> doCustomerLogin(@RequestBody LoginRequest loginRequest) {
		Customer customer = customerService.customerLogin(loginRequest.getUsername(), loginRequest.getPassword());

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(customer.getId());
		loginResponse.setFirstName(customer.getFirstName());
		loginResponse.setLastName(customer.getLastName());

		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}

	/*
	 * @DeleteMapping("/delete") public ResponseEntity<?>
	 * deleteCustomer(@PathVariable("customerId") int customerId) {
	 * ResponseEntity<Object> responseEntity = null;
	 * customerService.getCustomerById(customerId); return new
	 * ResponseEntity<>("Customer data deleted successfully", HttpStatus.OK);
	 *
	 * }
	 */
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") int customerId) {
		// ResponseEntity<Object> responseEntity = null;
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);

	}
	@GetMapping("/customer/email")
    public ResponseEntity<String> validateM(@RequestParam ("emailId") String emailId ){
        Customer customer = customerService.validateCustomerByEmail(emailId);
        ResponseEntity<String> responseEntity= null;
        if(customer != null) {
             responseEntity= new ResponseEntity<>("code has been send", HttpStatus.OK);
        }
        else {
             responseEntity = new ResponseEntity<>("mobile no not registered", HttpStatus.NOT_FOUND);
            
        }
        return responseEntity;
        
        }

}