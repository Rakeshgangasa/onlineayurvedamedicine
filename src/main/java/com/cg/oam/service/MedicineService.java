package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.Medicine;

public interface MedicineService {
	
	public List<Medicine> getAllMedicines();
	
	
	public Medicine addMedicine(String categoryId ,Medicine medicine);
	
	public Medicine getMedicineById(int id);
	

	public Medicine getMedicineByName(String name);


	public void deleteMedicineById(int medicineId);

	Medicine updateMedicine(Medicine medicine);
	
	

}