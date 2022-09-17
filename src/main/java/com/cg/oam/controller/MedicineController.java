package com.cg.oam.controller;

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
@RequestMapping("/medicine")
public class MedicineController {
	
	@Autowired
	MedicineService medicineService;
	
	@GetMapping("/getallmedicines")
	public List<Medicine> getMedicines() {
		List<Medicine> allMedicineList = (List<Medicine>) medicineService.getAllMedicines();
		return allMedicineList;
	}

	@GetMapping("/getmedicinebyid/{id}")
	public ResponseEntity<Medicine> getMedicineByid(@PathVariable("id") int id) {
		Medicine medicine = medicineService.getMedicineById(id);
		if (medicine == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(medicine));
	}
	
	@GetMapping("/getmedicinebyname/{name}")
	public ResponseEntity<Medicine> getMedicineByName(@PathVariable("name") String name) {
		Medicine medicine = medicineService.getMedicineByName(name);
		if (medicine == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(medicine));
		
	}
	
	@PostMapping( "/{categoryId}/add")
	public ResponseEntity<Medicine> addMedicine(@PathVariable String categoryId ,@RequestBody Medicine medicineId) {

	Medicine m = medicineService.addMedicine(categoryId,medicineId);
	
		return new ResponseEntity <>(m,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("medicineId") int medicineId) {
		
			medicineService.deleteMedicine(medicineId);
		    ResponseEntity<String> responseEntity = new ResponseEntity<>("medicine Deleted Successfully!!",HttpStatus.OK);
		    return responseEntity;
		}
	@PostMapping("/medicine/save")
	public ResponseEntity<Medicine> addProduct(@RequestBody Medicine medicine) {
		Medicine newMedicine = medicineService.saveMedicine(medicine);
		ResponseEntity<Medicine> responseEntity = new ResponseEntity<>(newMedicine,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/updatemedicine")
	public ResponseEntity<?> updateMedicine(@RequestBody Medicine medicine) {

		ResponseEntity<Object> responseEntity = null;
		Medicine updateMedicine = medicineService.updateMedicine(medicine);
		responseEntity = new ResponseEntity<>(updateMedicine, HttpStatus.OK);
		return responseEntity;
	}

}