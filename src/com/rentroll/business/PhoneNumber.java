package com.rentroll.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumber implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phoneNumberId;
	
	@ManyToOne
	private Person person;
	private String phoneType;
	private String phoneNumber;
	private boolean primaryNumber;
	
	
	public int getPhoneNumberId() {
		return phoneNumberId;
	}
	public void setPhoneNumberId(int phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
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
	public PhoneNumber(Person person, String phoneType, String phoneNumber){
		this();
		this.person=person;
		this.phoneType=phoneType;
		this.phoneNumber=phoneNumber;
	}
}
