package com.rentroll.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;



@Entity
public class Owner extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String paymentMethod;
	private long rentPercent;
	@OneToMany(targetEntity = Property.class, mappedBy="owner", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Property> properties;

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public long getRentPercent() {
		return rentPercent;
	}
	public void setRentPercent(long rentPercent) {
		this.rentPercent = rentPercent;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	

}