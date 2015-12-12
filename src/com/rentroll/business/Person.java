package com.rentroll.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Person implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;
	private String firstName;
	private String lastName;
	private String middleName;	
	
	@OneToMany(targetEntity = EmailAddress.class, mappedBy="person", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<EmailAddress> emailAddresses = new ArrayList<>();

	@OneToMany(targetEntity = PhoneNumber.class, mappedBy="person", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<PhoneNumber> phoneNumbers = new ArrayList<>();

	@OneToMany(targetEntity = Address.class, mappedBy="person", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();
	
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public List<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}
	public void setEmailAddresses(List<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Person(){
	}
	
	public Person(String firstName, String lastName){
		this();
		this.firstName= firstName;
		this.lastName= lastName;
	}
	
}
