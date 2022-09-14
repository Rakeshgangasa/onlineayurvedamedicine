package com.cg.oam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Medicine;
import com.cg.oam.exception.MedicineNotFoundException;
import com.cg.oam.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {
	

	@Autowired
	MedicineRepository medicineRepository;

	@Override
	public List<Medicine> getAllMedicines() {
		List<Medicine> medicines = medicineRepository.findAll();
		return medicines;
	}

	@Override
	public Medicine addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		System.out.println("paracetmol");
		return medicineRepository.save(medicine);
		
	}

	public Medicine getMedicineById(int id) {
		// TODO Auto-generated method stub
		return medicineRepository.findMedicineById(id);
		
	}
	public Medicine getMedicineByName(String name) {
		// TODO Auto-generated method stub
		return medicineRepository.findMedicineByName(name);
		
	}

	@Override
	public void deleteMedicine(String name) {
		Medicine medicine = medicineRepository.findMedicineByName(name);
		if(medicine != null) {
			medicineRepository.deleteByName(name);
		}else {
			throw new MedicineNotFoundException("Medicine not found");
		}
		
	}

	public Medicine UpdateMedicineById(int id, Medicine medicine) {
		
		Medicine medicineUpdate = medicineRepository.findMedicineById(id);
		if(medicineUpdate != null) {
			return medicineRepository.save(medicine);
		}else {
			throw new MedicineNotFoundException("medicine not found");
		}
		
	}

}
