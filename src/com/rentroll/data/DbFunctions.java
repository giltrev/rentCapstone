package com.rentroll.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.rentroll.business.Person;



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
}
