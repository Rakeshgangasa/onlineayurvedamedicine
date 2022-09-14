package com.cg.oam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository <Medicine,Integer> {

	/* Medicine findMedicineById(int id); */
	
	Medicine findByMedicineName(String name);
	
	void deleteByMedicineName(String name);

	Medicine findByMedicineId(int medicineId);

}
