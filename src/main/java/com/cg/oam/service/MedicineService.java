package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.Medicine;

public interface MedicineService {

	public List<Medicine> getAllMedicines();

	public Medicine getMedicineById(int id);

	public Medicine getMedicineByName(String name);

	Medicine updateMedicine(Medicine medicine);

	public void deleteMedicine(int medicineId);

	public Medicine saveMedicine(Medicine medicine);

	Medicine addMedicine(String categoryId, Medicine medicine);

}