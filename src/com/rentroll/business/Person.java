package com.rentroll.business;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




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
	private boolean activePerson = true;
	private String password;
	private String userName;
	
	@OneToOne()
	@JoinColumn(name="createdById")
	private PropertyManager createdBy;
	@OneToOne
	@JoinColumn(name="updateById")
	private PropertyManager updatedBy;
    
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;
	

	
    @PrePersist
    protected void onCreate() {
    updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    updated = new Date();
    }

	
	//mappedBy="person"
	@OneToMany(targetEntity = EmailAddress.class,mappedBy="person", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<EmailAddress> emailAddresses = new HashSet<>();

	//mappedBy="person"
	@OneToMany(targetEntity = PhoneNumber.class, mappedBy="person", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<PhoneNumber> phoneNumbers = new HashSet<>();
	 
	@OneToMany(targetEntity = Address.class, mappedBy="person",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Address> addresses = new HashSet<>();
	
	
	
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
	

	public Set<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}
	public void setEmailAddresses(Set<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
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
	public boolean isActivePerson() {
		return activePerson;
	}
	public void setActivePerson(boolean activePerson) {
		this.activePerson = activePerson;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreated() {
		return created;
	}

//	public void setCreated(Date created) {
//		this.created = created;
//	}

	public Date getUpdated() {
		return updated;
	}

	public PropertyManager getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(PropertyManager createdBy) {
		this.createdBy = createdBy;
	}

	public PropertyManager getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(PropertyManager updatedBy) {
		this.updatedBy = updatedBy;
	}

//	public void setUpdated(Date updated) {
//		this.updated = updated;
//	}
	
}
