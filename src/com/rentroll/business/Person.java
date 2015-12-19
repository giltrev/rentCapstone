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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;




@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	
	private int personId;
	private String firstName;
	private String lastName;
	private String middleName;	
	private boolean isActive;
	private String password;
	private String userName;
	
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	
	public Person(String firstName, String middleName, String lastName){
		this();
		this.firstName= firstName;
		this.middleName= middleName;
		this.lastName= lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getuserName() {
		return userName;
	}
	public void setUserId(String userName) {
		this.userName = userName;
	}
	
}
