package com.rentroll.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class PhoneNumber implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phoneNumberId;
	
	private String phoneType;
	private String phoneNumber;
	private boolean primaryNumber;
	
	
	public int getPhoneNumberId() {
		return phoneNumberId;
	}
	public void setPhoneNumberId(int phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isPrimaryNumber() {
		return primaryNumber;
	}
	public void setPrimaryNumber(boolean primaryNumber) {
		this.primaryNumber = primaryNumber;
	}
	public PhoneNumber(){
		
	}
	public PhoneNumber( boolean primaryNumber, String phoneType, String phoneNumber){
		this();
		this.primaryNumber = primaryNumber;
		this.phoneType=phoneType;
		this.phoneNumber=phoneNumber;
	}
}
