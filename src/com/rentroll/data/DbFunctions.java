package com.rentroll.data;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.xml.bind.DatatypeConverter;

import com.rentroll.business.Address;
import com.rentroll.business.Contact;
import com.rentroll.business.EmailAddress;
import com.rentroll.business.LedgerEntry;
import com.rentroll.business.Owner;
import com.rentroll.business.Person;
import com.rentroll.business.PhoneNumber;
import com.rentroll.business.Picture;
import com.rentroll.business.PropertyManager;
import com.rentroll.business.RentProperty;
import com.rentroll.business.ServiceCall;
import com.rentroll.business.Tenant;
import com.rentroll.business.Unit;
import com.rentroll.business.Vendor;



public class DbFunctions {
	
	public static void insert(Object object) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(object);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static Object insertObjectId(Owner owner) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(owner);
            trans.commit();
            Object id = DBUtil.getEmFactory().getPersistenceUnitUtil().getIdentifier(owner);
            return id;
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
            return "no"; 
        } finally {
            em.close();
        }
    }
	

    public static void update(Object object) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(object);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    
    public static void updateOwner(Owner owner) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(owner);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Object object) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(object));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
    public static Date getDate(String dateString) {
		Date date=null;
		try {
			date = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
    public static Person selectPerson(int personId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Person u " +
                "WHERE u.personId = :personId";
        TypedQuery<Person> q = em.createQuery(qString, Person.class);
        q.setParameter("personId", personId);
        try {
            Person person = q.getSingleResult();
            return person;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static List<Owner> selectActiveOwners() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i from Owner i " +
                "WHERE i.activePerson = true";
        TypedQuery<Owner> q = em.createQuery(qString, Owner.class);
        List<Owner> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    } 
    public static List<Person> selectActivePerons() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i from Person i " +
                "WHERE i.isActive = true";
        TypedQuery<Person> q = em.createQuery(qString, Person.class);
        List<Person> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    }  
    
    public static List<Contact> selectActiveContacts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i from Contact i " +
                "WHERE i.active = true";
        TypedQuery<Contact> q = em.createQuery(qString, Contact.class);
        List<Contact> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    } 
    
    
    public static List<Person> selectAllPerons() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i from Person i " ;
        TypedQuery<Person> q = em.createQuery(qString, Person.class);
        List<Person> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    }  
    public static List<Owner> selectAllOwners() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i from Owner i " ;
        TypedQuery<Owner> q = em.createQuery(qString, Owner.class);
        List<Owner> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    } 
    public static List<Vendor> selectAllVendor() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i from Vendor i " ;
        TypedQuery<Vendor> q = em.createQuery(qString, Vendor.class);
        List<Vendor> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    }
    
    public static Contact selectContact(int contactId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Contact u " +
                "WHERE u.contactId = :contactId";
        TypedQuery<Contact> q = em.createQuery(qString, Contact.class);
        q.setParameter("contactId", contactId);
        try {
        	Contact contact = q.getSingleResult();
            return contact;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static Owner selectOwner(int personId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Owner u " +
                "WHERE u.personId = :personId";
        TypedQuery<Owner> q = em.createQuery(qString, Owner.class);
        q.setParameter("personId", personId);
        try {
            Owner owner = q.getSingleResult();
            return owner;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static EmailAddress selectEmailAddress(int emailAddressId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM EmailAddress u " +
                "WHERE u.emailAddressId = :emailAddressId";
        TypedQuery<EmailAddress> q = em.createQuery(qString, EmailAddress.class);
        q.setParameter("emailAddressId", emailAddressId);
        try {
        	EmailAddress emailAddress = q.getSingleResult();
            return emailAddress;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static PhoneNumber selectPhoneNumber(int phoneNumberId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM PhoneNumber u " +
                "WHERE u.phoneNumberId = :phoneNumberId";
        TypedQuery<PhoneNumber> q = em.createQuery(qString, PhoneNumber.class);
        q.setParameter("phoneNumberId", phoneNumberId);
        try {
        	PhoneNumber phoneNumber = q.getSingleResult();
            return phoneNumber;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    
    public static Address selectAddress(int addressId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Address u " +
                "WHERE u.addressId = :addressId";
        TypedQuery<Address> q = em.createQuery(qString, Address.class);
        q.setParameter("addressId", addressId);
        try {
        	Address address = q.getSingleResult();
            return address;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    
    public static RentProperty selectProperty(int propId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM RentProperty u WHERE u.propId = :propId";
        TypedQuery<RentProperty> q = em.createQuery(qString, RentProperty.class);
        q.setParameter("propId", propId);
        try {
        	RentProperty property = q.getSingleResult();
            return property;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static List<Tenant> selectAllTenants() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i FROM Tenant i ORDER BY i.lastName, i.firstName" ;
        TypedQuery<Tenant> q = em.createQuery(qString, Tenant.class);
        List<Tenant> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    } 
    public static Tenant selectTenant(int personId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Tenant u " +
                "WHERE u.personId = :personId";
        TypedQuery<Tenant> q = em.createQuery(qString, Tenant.class);
        q.setParameter("personId", personId);
        try {
        	Tenant tenant = q.getSingleResult();
            return tenant;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static List<Vendor> selectAllVendors() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i FROM Vendor i ORDER BY i.lastName, i.firstName" ;
        TypedQuery<Vendor> q = em.createQuery(qString, Vendor.class);
        List<Vendor> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    } 
    public static Vendor selectVendor(int personId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Vendor u " +
                "WHERE u.personId = :personId";
        TypedQuery<Vendor> q = em.createQuery(qString, Vendor.class);
        q.setParameter("personId", personId);
        try {
        	Vendor vendor = q.getSingleResult();
            return vendor;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static Vendor selectVendorUserName(String userName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Vendor u " +
                "WHERE u.userName = :userName";
        TypedQuery<Vendor> q = em.createQuery(qString, Vendor.class);
        q.setParameter("userName", userName);
        try {
        	Vendor vendor = q.getSingleResult();
            return vendor;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static String ownerLogin(String userName){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Owner u " +
                "WHERE u.userName = :userName";
        TypedQuery<Owner> q = em.createQuery(qString, Owner.class);
        q.setParameter("userName", userName);
        try {
            Owner owner = q.getSingleResult();
            System.out.println("Is a tenant" + userName + "password" + owner.getPassword()); 
            return owner.getPassword();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }   
    public static String tenantLogin(String userName){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Tenant u " +
                "WHERE u.userName = :userName";
        TypedQuery<Tenant> q = em.createQuery(qString, Tenant.class);
        q.setParameter("userName", userName);
        try {
        	Tenant tenant = q.getSingleResult();
//        	System.out.println("Is a tenant" + userName + "password" + tenant.getPassword());    
        	return tenant.getPassword();
        } catch (NoResultException e) {
	        	System.out.println("not a tenant" + userName);     
	        	return null;
        } finally {
            em.close();
        }
    } 
    public static String vendorLogin(String userName){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Vendor u " +
                "WHERE u.userName = :userName";
        TypedQuery<Vendor> q = em.createQuery(qString, Vendor.class);
        q.setParameter("userName", userName);
        try {
        	Vendor vendor = q.getSingleResult();
            return vendor.getPassword();
        } catch (NoResultException e) {
        System.out.println("not a Vendor");    
        	return null;
        } finally {
            em.close();
        }
    }
    
    public static String propManagerLogin(String userName){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM PropertyManager u " +
                "WHERE u.userName = :userName";
        TypedQuery<PropertyManager> q = em.createQuery(qString, PropertyManager.class);
        q.setParameter("userName", userName);
        try {
        	PropertyManager propManager = q.getSingleResult();
            return propManager.getPassword();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static Owner getOwnerUserName(String userName){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Owner u " +
                "WHERE u.userName = :userName";
        TypedQuery<Owner> q = em.createQuery(qString, Owner.class);
        q.setParameter("userName", userName);
        try {
        	Owner owner = q.getSingleResult();
            return owner;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static PropertyManager getPropManagerUserName(String userName){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM PropertyManager u " +
                "WHERE u.userName = :userName";
        TypedQuery<PropertyManager> q = em.createQuery(qString, PropertyManager.class);
        q.setParameter("userName", userName);
        try {
        	PropertyManager propManger = q.getSingleResult();
            return propManger;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static Vendor getVendorUserName(String userName){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Vendor u " +
                "WHERE u.userName = :userName";
        TypedQuery<Vendor> q = em.createQuery(qString, Vendor.class);
        q.setParameter("userName", userName);
        try {
        	Vendor vendor = q.getSingleResult();
            return vendor;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static Tenant getTenantUserName(String userName){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Tenant u " +
                "WHERE u.userName = :userName";
        TypedQuery<Tenant> q = em.createQuery(qString, Tenant.class);
        q.setParameter("userName", userName);
        try {
        	Tenant tenant = q.getSingleResult();
            return tenant;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static List<ServiceCall> selectAllOpenServiceCalls() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i from ServiceCall i " +
        		"WHERE i.status != :status";
        TypedQuery<ServiceCall> q = em.createQuery(qString, ServiceCall.class);
        q.setParameter("status", "Complete");
        List<ServiceCall> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    }
    
    
    public static List<ServiceCall> vendorServiceCalls(Vendor vendor) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString ="SELECT i from ServiceCall i " +
        		"WHERE :venodr MEMBER OF  ServiceCall.vendors";
        TypedQuery<ServiceCall> q = em.createQuery(qString, ServiceCall.class);
        q.setParameter("vendor", vendor);
        List<ServiceCall> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    }
    
    
    public static void addRents(){
	    Calendar firstOfMonthCal = Calendar.getInstance();   
	    firstOfMonthCal.set(Calendar.DAY_OF_MONTH, 1);
	    Date firstOfMonth = firstOfMonthCal.getTime();
	    
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i from Unit i " ;
//                "WHERE i.tenant IS NOT NULL";
        
        
        TypedQuery<Unit> q = em.createQuery(qString, Unit.class);
        List<Unit> units = null;
        try {
            units = q.getResultList();
        } catch (NoResultException ex) {
        		units = null;
        } finally {
            em.close();
        }
        
        for (Unit unit : units) {
        		int counter = 0;	
        		
	        	Set<LedgerEntry> unitledgerEntries = unit.getLedgerEntries();
	        	if (unitledgerEntries.size()!=0){
		        	for (LedgerEntry ledgerEntry : unitledgerEntries) {
		        		Calendar calendar = Calendar.getInstance();
		        		calendar.setTime(ledgerEntry.getDate());
		        		if (calendar.YEAR==firstOfMonthCal.YEAR &&
		        				calendar.MONTH==firstOfMonthCal.MONTH &&
		        				calendar.DAY_OF_MONTH==firstOfMonthCal.DAY_OF_MONTH){
		        			counter++;
		        		}	
		        	}
	        	}
	
	        	if (counter==0){
	        		LedgerEntry ledgerEnty = new LedgerEntry();	
	        		ledgerEnty.setAccountName("RentCharge");
	        		ledgerEnty.setDate(firstOfMonth);
	        		ledgerEnty.setUnit(unit);
	        		ledgerEnty.setDebit(unit.getRentRate());	
	
	        		DbFunctions.insert(ledgerEnty);
	        	}
        	
        	
        	
		        
        }
    }
    
    public static List<RentProperty> selectAvailableUnits() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u.property from Unit u " +
        		" WHERE u.status = 'Available'";
        TypedQuery<RentProperty> q = em.createQuery(qString, RentProperty.class);
        
        List<RentProperty> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        System.out.println("DB Functions Results size is "+results.size());
        return results;
    }

	public static Tenant selectTenantUserName(String userName) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Tenant u " +
                "WHERE u.userName = :userName";
        TypedQuery<Tenant> q = em.createQuery(qString, Tenant.class);
        q.setParameter("userName", userName);
        try {
        	Tenant tenant = q.getSingleResult();
            return tenant;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
	}
	
	public static byte[] selectImage(int id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Picture u " +
                "WHERE u.id = :id";
        TypedQuery<Picture> q = em.createQuery(qString, Picture.class);
        q.setParameter("id", id);
        try {
        	Picture picture = q.getSingleResult();
            return picture.getImageFile();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
	}
	public static byte[] selectIcon(int id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Picture u " +
                "WHERE u.id = :id";
        TypedQuery<Picture> q = em.createQuery(qString, Picture.class);
        q.setParameter("id", id);
        try {
        	Picture picture = q.getSingleResult();
            return picture.getIcon();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
	}
    
	public static List<RentProperty> SelectAllProperties() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from RentProperty u ";
        TypedQuery<RentProperty> q = em.createQuery(qString, RentProperty.class);
        
        List<RentProperty> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        System.out.println("DB Functions Results size is "+results.size());
        return results;
    }
	public static List<Unit> selectAllUnits() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from Unit u " ;
        TypedQuery<Unit> q = em.createQuery(qString, Unit.class);
        
        List<Unit> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        System.out.println("There are Units "+results.size());
        return results;
    }
	public static Unit selectUnit(int id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Unit u " +
                "WHERE u.id = :id";
        TypedQuery<Unit> q = em.createQuery(qString, Unit.class);
        q.setParameter("id", id);
        try {
        	Unit unit = q.getSingleResult();
            return unit;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
	}
	
	public static ServiceCall selectServiceCall(int id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM ServiceCall u " +
                "WHERE u.scId = :id";
        TypedQuery<ServiceCall> q = em.createQuery(qString, ServiceCall.class);
        q.setParameter("id", id);
        try {
        	ServiceCall serviceCall = q.getSingleResult();
            return serviceCall;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
	}
	
	   public static String hashPassword( String passwordIn, final byte[] salt) {
		   final int iterations= 1000;
		   final int keyLength = 100;
		   String hexSalt = DatatypeConverter.printHexBinary(salt);
		   String passwordAndSalt =  passwordIn+hexSalt;
		   
		   final char[] password = passwordAndSalt.toCharArray();
	       try {
	           SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
	           PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
	           SecretKey key = skf.generateSecret( spec );
	           byte[] res = key.getEncoded( );
	           String enteredHex = DatatypeConverter.printHexBinary(res);
	           return enteredHex;
	 
	       } catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
	           throw new RuntimeException( e );
	       }
	   }
	   public static byte[] getSalt(){
		   Random random = new Random();
			byte[] salt = new byte[4];
			random.nextBytes(salt);
			return salt;
	   }
}
