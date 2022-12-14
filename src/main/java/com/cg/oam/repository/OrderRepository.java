package com.cg.oam.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.oam.entity.Order;



@Repository
public interface OrderRepository extends JpaRepository <Order,Integer> {

	/* Medicine findMedicineById(int id); */
	
	void deleteByOrderId(int OrderId);

	Order findByOrderId(int OrderId);
	

}
