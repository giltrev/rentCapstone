package com.rentroll.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "PropertyManager")

public class PropertyManager extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String companyname;
	private String pmType;

	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPmType() {
		return pmType;
	}
	public void setPmType(String pmType) {
		this.pmType = pmType;
	}



}
