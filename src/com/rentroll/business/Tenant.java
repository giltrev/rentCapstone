package com.rentroll.business;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Tenant extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Unit unit;
	private Date birthDate;
	private Picture picture;
	private Date leaseExpirationDate;
	private int dlNumber;
	private String dlNumberState;
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public Date getLeaseExpirationDate() {
		return leaseExpirationDate;
	}
	public void setLeaseExpirationDate(Date leaseExpirationDate) {
		this.leaseExpirationDate = leaseExpirationDate;
	}
	public int getDlNumber() {
		return dlNumber;
	}
	public void setDlNumber(int dlNumber) {
		this.dlNumber = dlNumber;
	}
	public String getDlNumberState() {
		return dlNumberState;
	}
	public void setDlNumberState(String dlNumberState) {
		this.dlNumberState = dlNumberState;
	}
	
	

}
