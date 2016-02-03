package com.rentroll.business;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Tenant")
public class Tenant extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@OneToOne
	private Unit unit;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	private Picture picture;
	
	@Temporal(TemporalType.DATE)
	private Date leaseStartDate;
	
	@Temporal(TemporalType.DATE)
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
	public Tenant(){}
	
	public Tenant(Unit unit, String firstName, String middleName, String lastName,  String birthDate, String leaseExpirationDate, int dlNumber, String dlNumberState){
		this();
		super.setFirstName(firstName);
		super.setMiddleName(middleName);
		super.setLastName(lastName);
		this.unit = unit;
		DateFormat format = new SimpleDateFormat("MM/DD/YYYY", Locale.ENGLISH);
		try {
			this.birthDate = format.parse(birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.birthDate = birthDate;
		try {
			this.leaseExpirationDate = format.parse(leaseExpirationDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.leaseExpirationDate = leaseExpirationDate;
		this.dlNumber = dlNumber;
		this.dlNumberState = dlNumberState;
		
	}
	public Date getLeaseStartDate() {
		return leaseStartDate;
	}
	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}
	
	
	

}
