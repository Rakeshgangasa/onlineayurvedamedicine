package com.cg.onlineayurvedamedicine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.entity.Medicine;
import com.cg.oam.repository.MedicineRepository;
import com.cg.oam.service.MedicineServiceImpl;

@SpringBootTest
public class MedicineServiceTest {
	@InjectMocks
    MedicineServiceImpl medicineServiceImpl = new MedicineServiceImpl();

    @Mock
    MedicineRepository medicineRepository;    

    @Test
    public void testGetMedicineById() {

        Medicine medicine = new Medicine();
        medicine.setMedicineId(1234);
        medicine.setMedicineName("paracetmol");
        medicine.setCompanyName("patanjali");
        medicine.setMfd(LocalDate.of(2020, 10, 10));
        medicine.setExpiryDate(LocalDate.of(2022, 07, 27));
        medicine.setMedicineCost(229);

        Optional<Medicine> optionalMedicine = Optional.of(medicine);

        when(medicineRepository.findById(1234)).thenReturn(optionalMedicine);

        Medicine medicineObj = medicineServiceImpl.getMedicineById(1234);

        assertEquals("paracetmol",medicineObj.getMedicineName());
        assertEquals(229,medicineObj.getMedicineCost());        
    }

}
