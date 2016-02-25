package com.rentroll.business;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name= "Vendor")
public class Vendor extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String companyName;
	private String paymentType;
	private String vendorType;
	@ManyToMany(mappedBy="vendors",fetch = FetchType.EAGER)
	private Set <ServiceCall> serviceCalls = null;
	@OneToOne
	@JoinColumn(name="picId")
	private Picture picture;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public Vendor(){}
	
	public Vendor(String firstName,String middleName,String lastName,String companyName,
			String vendorType, Boolean active){
		this();
		super.setFirstName(firstName);
		super.setMiddleName(middleName);
		super.setLastName(lastName);
		this.companyName = companyName;
		this.vendorType = vendorType;
		super.setActivePerson(active);
	}
	public Set<ServiceCall> getServiceCalls() {
		return serviceCalls;
	}
	public void setServiceCalls(Set<ServiceCall> serviceCalls) {
		this.serviceCalls = serviceCalls;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

}
