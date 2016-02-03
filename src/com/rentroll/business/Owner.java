package com.rentroll.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity

@Table(name= "Owner")
public class Owner extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String paymentMethod;
	
	@OneToMany(targetEntity = RentProperty.class, mappedBy="owner", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<RentProperty> properties;

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public List<RentProperty> getProperties() {
		return properties;
	}
	public void setProperties(List<RentProperty> properties) {
		this.properties = properties;
	}
	public Owner(){
		
	}
public Owner(String firstName, String middleName, String lastName, String paymentMethod){
	this();
	this.paymentMethod= paymentMethod;
	super.setFirstName(firstName);
	super.setMiddleName(middleName);
	super.setLastName(lastName);
	}

}
