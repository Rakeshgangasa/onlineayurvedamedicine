package com.cg.oam.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="medicine_tbl")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medicine_id")
	private int medicineId;
	 @NotNull(message = "Name cannot be null")
	@Column(name="medicine_Name")
	private String medicineName;
	@Column(name="medicine_Cost")
	private float medicineCost;
	@PastOrPresent
	@Column(name="mfd")
	private LocalDate mfd;
	@FutureOrPresent
	@Column(name="expiry_date")
	private LocalDate expiryDate;
	 @NotNull(message = "companyName cannot be Blank")
	@Column(name="company_Name")
	private String companyName;
	@ManyToOne
	@JoinColumn(name = "category_Id")
	@JsonIgnore
	private Category category;
	
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public float getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(float medicineCost) {
		this.medicineCost = medicineCost;
	}
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineCost="
				+ medicineCost + ", mfd=" + mfd + ", expiryDate=" + expiryDate + ", companyName=" + companyName
				+ ", category=" + category + "]";
	}
}
