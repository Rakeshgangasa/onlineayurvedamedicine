package com.cg.oam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.oam.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByUsername(String username);
	@Query("select customer from Customer customer where customer.email=?1")
    public Optional <Customer> findByEmailId(String email);

}