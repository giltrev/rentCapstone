package com.rentroll.business;

import java.util.List;

public class Owner extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ownerId;
	private String paymentMethod;
	private long rentPercent;
	private List<Property> properties;
	
	
	
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public long getRentPercent() {
		return rentPercent;
	}
	public void setRentPercent(long rentPercent) {
		this.rentPercent = rentPercent;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	@Override
	public int getPersonId() {
		// TODO Auto-generated method stub
		return super.getPersonId();
	}
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}
	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);
	}
	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}
	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}
	@Override
	public String getMiddleName() {
		// TODO Auto-generated method stub
		return super.getMiddleName();
	}
	@Override
	public void setMiddleName(String middleName) {
		// TODO Auto-generated method stub
		super.setMiddleName(middleName);
	}
	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return super.isActive();
	}
	@Override
	public void setActive(boolean isActive) {
		// TODO Auto-generated method stub
		super.setActive(isActive);
	}
	@Override
	public List<EmailAddress> getEmailAddresses() {
		// TODO Auto-generated method stub
		return super.getEmailAddresses();
	}
	@Override
	public void setEmailAddresses(List<EmailAddress> emailAddresses) {
		// TODO Auto-generated method stub
		super.setEmailAddresses(emailAddresses);
	}
	@Override
	public List<PhoneNumber> getPhoneNumbers() {
		// TODO Auto-generated method stub
		return super.getPhoneNumbers();
	}
	@Override
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		// TODO Auto-generated method stub
		super.setPhoneNumbers(phoneNumbers);
	}
	@Override
	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		return super.getAddresses();
	}
	@Override
	public void setAddresses(List<Address> addresses) {
		// TODO Auto-generated method stub
		super.setAddresses(addresses);
	}
	

}
