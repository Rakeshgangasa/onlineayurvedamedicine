package com.cg.oam.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oam.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	Customer doCustomerLogin(String username, String password);
	
	/*
	 * @Query("Select c from Customer c where c.username = :uname and c.password = :upwd"
	 * ) public Customer doCustomerLogin(@Param("uname") String
	 * username, @Param("upwd") String password);
	 */
}
