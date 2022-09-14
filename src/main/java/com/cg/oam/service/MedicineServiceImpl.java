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
		
		return medicineRepository.save(medicine);
		
	}

	public Medicine getMedicineById(int id) {
		// TODO Auto-generated method stub
		return medicineRepository.findById(id).get();
		
	}
	public Medicine getMedicineByName(String name) {
		// TODO Auto-generated method stub
		return medicineRepository.findByMedicineName(name);
		
	}

	public void deleteMedicineById(int medicineId) {
		Medicine medicine = medicineRepository.findByMedicineId(medicineId);
		if(medicine != null) {
			medicineRepository.delete(medicine);
		}else {
			throw new MedicineNotFoundException("Medicine not found");
		}
		
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		Medicine updateMedicine = getMedicineById(medicine.getMedicineId());
		updateMedicine = medicineRepository.save(medicine);
		return updateMedicine;
	}


	
}
