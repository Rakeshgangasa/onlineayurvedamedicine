package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.Medicine;

public interface MedicineService {
	
	public List<Medicine> getAllMedicines();
	
	public Medicine addMedicine(Medicine medicine);
	
	public Medicine getMedicineById(int id);
	
	public void deleteMedicine(String id);
	
	
	
	public Medicine getMedicineByName(String name);

	Medicine UpdateMedicineById(int id, Medicine medicine);
	
	

}