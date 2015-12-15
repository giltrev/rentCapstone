package com.rentroll.business;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Person1")
public class Person1 extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyName;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
	

}
