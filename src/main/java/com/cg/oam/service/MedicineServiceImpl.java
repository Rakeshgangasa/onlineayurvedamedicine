package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Category;
import com.cg.oam.entity.Medicine;
import com.cg.oam.exception.CategoryNotFoundException;
import com.cg.oam.exception.MedicineNotFoundException;
import com.cg.oam.repository.CategoryRepository;
import com.cg.oam.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MedicineRepository medicineRepository;
	@Autowired
	CategoryRepository categoryRepository ;

	@Override
	public List<Medicine> getAllMedicines() {
		List<Medicine> medicines = medicineRepository.findAll();
		return medicines;
	}

	@Override
	public Medicine addMedicine(String categoryId, Medicine medicine) {
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new CategoryNotFoundException("Category not existing with id : "+categoryId);
		}
		Category category = optionalCategory.get();
		medicine.setCategory(category);
		Medicine newMedicine = medicineRepository.save(medicine);
		return newMedicine;
	}
	
	

	public Medicine getMedicineById(int id) {
		Optional <Medicine> optionalMedicine= medicineRepository.findById(id);
		
		if (optionalMedicine.isEmpty()) {
			String exceptionMessage = "MedicineId does not exist .";
			LOG.warn(exceptionMessage);
			throw new MedicineNotFoundException(exceptionMessage);
		} 
			LOG.info("List returned successfully.");
			return  optionalMedicine.get();
		}
		
	public Medicine saveMedicine(Medicine medicine) {
		Medicine newMedicine = medicineRepository.save(medicine);
		return newMedicine;
	}
	public Medicine getMedicineByName(String name) {
		
		Medicine medicine= medicineRepository.findByMedicineName(name);
		 if(medicine != null) {
				medicineRepository.delete(medicine);
			}else {
				throw new MedicineNotFoundException("Medicine not found");
			}
		return medicine;
		
	}


	public void deleteMedicine(int medicineId) {
		Optional<Medicine> optionalMedicine = medicineRepository.findById(medicineId);
		if(optionalMedicine.isEmpty()) {
			throw new MedicineNotFoundException("medicine not existing with id: "+medicineId);
		}
		medicineRepository.deleteById(medicineId);
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
			Optional<Medicine> optionalMedicine = medicineRepository.findById(medicine.getMedicineId());
			if(optionalMedicine.isEmpty()) {
				throw new MedicineNotFoundException("No medicinewith this id:"+medicine.getMedicineId());
			}
			Medicine updatedMedicine = medicineRepository.save(medicine);
			return updatedMedicine;
		}

	}


	
