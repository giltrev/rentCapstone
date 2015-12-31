package com.rentroll.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Unit")
public class Unit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int unitId;
	@ManyToOne
	@JoinColumn(name="property_Id")
	private Property property;
	

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

	public Unit(){}
	
	public Unit(Property property, String unitNumber, int numberOfBedrooms, int numberOfBathrooms, double rentRate, double squareFootage, String floorplan, String status){
		this();
		this.property= property;
		this.unitNumber= unitNumber;
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathrooms;
		this.rentRate= rentRate;
		this.squareFootage = squareFootage;
		this.floorplan = floorplan;
		this.status = status;
		
	}


}
