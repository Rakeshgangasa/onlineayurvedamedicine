/*package com.cg.oam.controller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.entity.Medicine;
import com.cg.oam.service.MedicineService;
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	MedicineService medicineService;
	
	@GetMapping("/get-all-medicines")
	public List<Medicine> getMedicines() {
		List<Medicine> allMedicineList = (List<Medicine>) medicineService.getAllMedicines();
		return allMedicineList;
	}
	@GetMapping("/get-medicine-by-name/{name}")
	public ResponseEntity<Medicine> getMedicineByName(@PathVariable("name") String name) {
		Medicine medicine = medicineService.getMedicineByName(name);
		if (medicine == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(medicine));
	}*/
	/*
	 * @PostMapping( "/add-medicine") public ResponseEntity<Medicine>
	 * addMedicine(@RequestBody Medicine medicine) {
	 * 
	 * Medicine m = medicineService.addMedicine(medicine); if (m != null) { return
	 * new ResponseEntity<Medicine>(m, HttpStatus.CREATED);
	 * 
	 * } return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build(); }
	 * 
	 * @DeleteMapping("/delete/{id}") public ResponseEntity<?>
	 * deleteMedicineById(@PathVariable("id") int medicineId) {
	 * 
	 * ResponseEntity<Object> responseEntity = null;
	 * medicineService.deleteMedicineById(medicineId); responseEntity = new
	 * ResponseEntity<>("Medicine data deleted successfully", HttpStatus.OK); return
	 * responseEntity; }
	 * 
	 * @PutMapping("/updatemedicine") public ResponseEntity<?>
	 * updateMedicine(@RequestBody Medicine medicine) {
	 * 
	 * ResponseEntity<Object> responseEntity = null; Medicine updateMedicine =
	 * medicineService.updateMedicine(medicine); responseEntity = new
	 * ResponseEntity<>(updateMedicine, HttpStatus.OK); return responseEntity; }
	 */


