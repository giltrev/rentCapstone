package com.rentroll.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.rentroll.business.Address;
import com.rentroll.business.EmailAddress;
import com.rentroll.business.Owner;
import com.rentroll.business.Person;
import com.rentroll.business.PhoneNumber;
import com.rentroll.business.Property;
import com.rentroll.business.Tenant;
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
    
    
    public static Property selectProperty(int propId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Property u WHERE u.propId = :propId";
        TypedQuery<Property> q = em.createQuery(qString, Property.class);
        q.setParameter("propId", propId);
        try {
        	Property property = q.getSingleResult();
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
    
}
