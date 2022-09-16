package com.cg.oam.model;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestPayload {
	 private int customerId;
	 private List<Integer> medicines= new ArrayList<>();
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<Integer> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Integer> medicines) {
		this.medicines = medicines;
	}
	 
}
	 
	 
	 
		
