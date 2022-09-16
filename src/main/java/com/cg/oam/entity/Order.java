package com.cg.oam.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="order_tbl")
public class Order {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	@Column(name="order_Date")
	private LocalDate orderDate;
	@Column(name="dispatch_Date")
	private LocalDate dispatchDate;
	@Column(name="total_Cost")
	private float totalCost;
	@Column(name="medicine_id")
	@OneToMany
	private List<Medicine> medicineList;
	@ManyToOne
	@JoinColumn(name="customer_Id")
	@JsonIgnore
	private Customer customer;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	public List<Medicine> getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(List<Medicine> medicineList) {
		this.medicineList = medicineList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", dispatchDate=" + dispatchDate
				+ ", totalCost=" + totalCost + ", medicineList=" + medicineList + ", customer=" + customer + "]";
	}
	
	
	
	
	
	
}
