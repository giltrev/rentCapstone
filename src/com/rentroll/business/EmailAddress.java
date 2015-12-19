package com.rentroll.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class EmailAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emailAddressId;
	
	@ManyToOne
	private Person person;
	private String emailAddressType;
	private String emailAddress;
	private boolean primaryEmail;
	
	
	
	public int getEmailAddressId() {
		return emailAddressId;
	}
	public void setEmailAddressId(int emailAddressId) {
		this.emailAddressId = emailAddressId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getEmailAddressType() {
		return emailAddressType;
	}
	public void setEmailAddressType(String emailAddressType) {
		this.emailAddressType = emailAddressType;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
	
	public boolean isPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(boolean primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public EmailAddress(){
		
	}
	public EmailAddress(Person person, boolean primaryEmail, String emailAddressType, String emailAddress){
		this();
		this.primaryEmail = primaryEmail;
		this.person= person;
		this.emailAddress= emailAddress;
		this.emailAddressType= emailAddressType;
		
	}
}
