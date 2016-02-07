package com.rentroll.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EmailAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emailAddressId;
	
	private String emailAddressType;
	private String emailAddress;
	private boolean primaryEmail;
	
	
	
	public int getEmailAddressId() {
		return emailAddressId;
	}
	public void setEmailAddressId(int emailAddressId) {
		this.emailAddressId = emailAddressId;
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
	public EmailAddress(boolean primaryEmail, String emailAddressType, String emailAddress){
		this();
		this.primaryEmail= primaryEmail;
		this.emailAddress= emailAddress;
		this.emailAddressType= emailAddressType;
		
	}
	
}
