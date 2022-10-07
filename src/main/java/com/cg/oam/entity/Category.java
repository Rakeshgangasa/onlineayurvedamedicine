package com.cg.oam.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="category_tbl")
public class Category {
	@Id

	@Column(name = "category_Id")
	private String categoryId;
	@NotNull(message = "Name cannot be null")
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "medicine_List")
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	@NotEmpty
	private List<Medicine> medicineList;
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Medicine> getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(List<Medicine> medicineList) {
		this.medicineList = medicineList;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", medicineList="
				+ medicineList + "]";
	}
}