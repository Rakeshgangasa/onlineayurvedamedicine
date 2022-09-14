package com.cg.oam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.entity.Medicine;
import com.cg.oam.service.MedicineService;

@RestController
@RequestMapping(value = { "/customer", "/admin" })
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/get-all-medicines")
	public List<Medicine> getMedicines() {
		List<Medicine> allMedicineList = (List<Medicine>) medicineService.getAllMedicines();
		return allMedicineList;
	}

	@GetMapping("/get-medicine-by-id/{id}")
	public ResponseEntity<Medicine> getMedicineByid(@PathVariable("id") int id) {
		Medicine medicine = medicineService.getMedicineById(id);
		if (medicine == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(medicine));
	}
	
	@GetMapping("/get-medicine-by-name/{name}")
	public ResponseEntity<Medicine> getMedicineByName(@PathVariable("name") String name) {
		Medicine medicine = medicineService.getMedicineByName(name);
		if (medicine == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(medicine));
	}
	

}