package com.cg.oam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository <Medicine,String> {

	Medicine findMedicineById(int id);
	
	Medicine findMedicineByName(String name);
	
	void deleteByName(String name);

}
