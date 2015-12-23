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
import javax.persistence.Table;

@Entity
@Table(name= "Property")
public class Property implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propId;
	
	@ManyToOne
	private Owner owner;
	private String propName;
	private String propAddress1;
	private String propAddress2;
	private String propCity;
	private String propState;
	private String propZip;
	private int numberOfUnits;
	private String propertyType;
	private double commission;
	private double ocupandyRate;
	@OneToMany(targetEntity = Unit.class, mappedBy="property", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Unit> units;

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	

	public int getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getOcupandyRate() {
		return ocupandyRate;
	}

	public void setOcupandyRate(double ocupandyRate) {
		this.ocupandyRate = ocupandyRate;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropAddress1() {
		return propAddress1;
	}

	public void setPropAddress1(String propAddress1) {
		this.propAddress1 = propAddress1;
	}

	public String getPropAddress2() {
		return propAddress2;
	}

	public void setPropAddress2(String propAddress2) {
		this.propAddress2 = propAddress2;
	}

	public String getPropCity() {
		return propCity;
	}

	public void setPropCity(String propCity) {
		this.propCity = propCity;
	}

	public String getPropState() {
		return propState;
	}

	public void setPropState(String propState) {
		this.propState = propState;
	}

	public String getPropZip() {
		return propZip;
	}

	public void setPropZip(String propZip) {
		this.propZip = propZip;
	}
	
	
}
