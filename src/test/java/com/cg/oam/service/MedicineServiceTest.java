package com.cg.oam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.entity.Medicine;
import com.cg.oam.exception.MedicineNotFoundException;
import com.cg.oam.repository.MedicineRepository;

@SpringBootTest
public class MedicineServiceTest {

	@InjectMocks
	MedicineServiceImpl medicineServiceImpl = new MedicineServiceImpl();

	@Mock
	MedicineRepository medicineRepository;

	@Test
	public void testGetMedicineById() {

		Medicine medicine = new Medicine();
		medicine.setMedicineId(101);
		medicine.setMedicineName("Ashwagandha");
		medicine.setMedicineCost(595);
		medicine.setMfd(LocalDate.of(2020, 10, 10));
		medicine.setExpiryDate(LocalDate.of(2021, 10, 10));

		Optional<Medicine> optionalMedicine = Optional.of(medicine);

		when(medicineRepository.findById(101)).thenReturn(optionalMedicine);

		Medicine medicineObj = medicineServiceImpl.getMedicineById(101);

		assertEquals("Ashwagandha", medicineObj.getMedicineName());
		assertEquals(595, medicineObj.getMedicineCost());
	}

	@Test
	public void testGetMedicineByIdException() {

		when(medicineRepository.findById(1020)).thenThrow(MedicineNotFoundException.class);

		assertThrows(MedicineNotFoundException.class, () -> medicineServiceImpl.getMedicineById(1020));
	}

	@Test
	public void testGetAllMedicines() {

		Medicine medicine = new Medicine();
		medicine.setMedicineId(101);
		medicine.setMedicineName("Ashwagandha");
		medicine.setMedicineCost(595);
		medicine.setMfd(LocalDate.of(2020, 10, 10));
		medicine.setExpiryDate(LocalDate.of(2021, 10, 10));

		Medicine medicine2 = new Medicine();
		medicine2.setMedicineId(102);
		medicine2.setMedicineName("Boswellia");
		medicine2.setMedicineCost(700);
		medicine2.setMfd(LocalDate.of(2020, 11, 14));
		medicine2.setExpiryDate(LocalDate.of(2021, 10, 10));

		Medicine medicine3 = new Medicine();
		medicine3.setMedicineId(103);
		medicine3.setMedicineName("Brahmi");
		medicine3.setMedicineCost(156);
		medicine3.setMfd(LocalDate.of(2020, 10, 18));
		medicine3.setExpiryDate(LocalDate.of(2021, 12, 10));

		List<Medicine> medicineList = new ArrayList<>();
		medicineList.add(medicine3);
		medicineList.add(medicine2);
		medicineList.add(medicine);

		when(medicineRepository.findAll()).thenReturn(medicineList);

		List<Medicine> medicines = medicineServiceImpl.getAllMedicines();

		assertEquals(3, medicines.size());
	}

	@Test
	public void testDeleteMedicine() {

		Medicine medicine = new Medicine();
		medicine.setMedicineId(101);
		medicine.setMedicineName("Ashwagandha");
		medicine.setMedicineCost(595);
		medicine.setMfd(LocalDate.of(2020, 10, 10));
		medicine.setExpiryDate(LocalDate.of(2021, 10, 10));

		Optional<Medicine> optionalMedicine = Optional.of(medicine);

		when(medicineRepository.findById(101)).thenReturn(optionalMedicine);

		doNothing().when(medicineRepository).deleteById(101);

		medicineServiceImpl.deleteMedicine(101);

		verify(medicineRepository, times(1)).findById(101);
		verify(medicineRepository, times(1)).deleteById(101);
	}

}
