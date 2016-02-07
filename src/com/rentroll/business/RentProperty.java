package com.rentroll.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Property")
public class RentProperty implements Serializable{

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
	private BigDecimal commission;
	private double ocupandyRate;
	
	@Lob
	@Column(name="description", length=5000)
	private String description;
	
	@OneToMany(targetEntity = Unit.class, mappedBy="property", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set <Unit> units;

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

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public double getOcupandyRate() {
		return ocupandyRate;
	}

	public void setOcupandyRate(double ocupandyRate) {
		this.ocupandyRate = ocupandyRate;
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

	public Set <Unit> getUnits() {
		return units;
	}

	public void setUnits(Set <Unit> units) {
		this.units = units;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
