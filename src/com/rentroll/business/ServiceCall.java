package com.rentroll.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class ServiceCall implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int scId;
	private Unit unit;
	private String serviceCallName;
	private String serviceCallDetail;
	@OneToMany
	private List<Vendor> vendors;
	private double partsCost;
	private double laborCost;
	
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public String getServiceCallName() {
		return serviceCallName;
	}
	public void setServiceCallName(String serviceCallName) {
		this.serviceCallName = serviceCallName;
	}
	public String getServiceCallDetail() {
		return serviceCallDetail;
	}
	public void setServiceCallDetail(String serviceCallDetail) {
		this.serviceCallDetail = serviceCallDetail;
	}
	public List<Vendor> getVendors() {
		return vendors;
	}
	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}
	public double getPartsCost() {
		return partsCost;
	}
	public void setPartsCost(double partsCost) {
		this.partsCost = partsCost;
	}
	public double getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(double laborCost) {
		this.laborCost = laborCost;
	}
	
	
	
	
}
