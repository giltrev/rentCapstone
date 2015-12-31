package com.rentroll.business;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= "Vendor")
public class Vendor extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String companyName;
	private String vendorType;
	@ManyToOne
	private ServiceCall serviceCall;
	
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
	public ServiceCall getServiceCall() {
		return serviceCall;
	}
	public void setServiceCall(ServiceCall serviceCall) {
		this.serviceCall = serviceCall;
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

}
