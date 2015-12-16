package com.rentroll.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Unit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int unitId;
	@ManyToOne
	private Property property;
	
	@OneToMany(targetEntity = Tenant.class, mappedBy="unit", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Tenant> tenants;
	private String unitNumber;
	private int numberOfBedrooms;
	private int numberOfBathrooms;
	private double rentRate;
	private double squareFootage;
	private String floorplan;
	
	@OneToMany(targetEntity = Amenity.class, mappedBy="unit", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Amenity> amenities;
	
	@OneToMany(targetEntity = Picture.class, mappedBy="unit", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Picture> pictures;
	private String status;
	
	
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}

	public String getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}
	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}
	public int getNumberOfBathrooms() {
		return numberOfBathrooms;
	}
	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}
	public double getRentRate() {
		return rentRate;
	}
	public void setRentRate(double rentRate) {
		this.rentRate = rentRate;
	}
	public double getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}
	public String getFloorplan() {
		return floorplan;
	}
	public void setFloorplan(String floorplan) {
		this.floorplan = floorplan;
	}
	public List<Amenity> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}
	public List<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public List<Tenant> getTenants() {
		return tenants;
	}
	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}
	
	

}
