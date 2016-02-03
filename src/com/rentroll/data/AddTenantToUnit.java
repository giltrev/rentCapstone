package com.rentroll.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.rentroll.business.Tenant;
import com.rentroll.business.Unit;

public class AddTenantToUnit {

	public static void addTenantToUnit(){
		List <Tenant> tenants =DbFunctions.selectAllTenants();
		for (Tenant tenant : tenants) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        String qString = "SELECT i from Unit i " +
	                "WHERE i.unitId = :unitId";
	        TypedQuery<Unit> q = em.createQuery(qString, Unit.class);
	        q.setParameter("unitId", tenant.getUnit().getUnitId());
	        
	        Unit unit = null;
	        try {
	            unit = q.getSingleResult();
	        } catch (NoResultException ex) {
	        		unit = null;
	        } finally {
	            em.close();
	        }
	        
	        unit.setTenant(tenant);
	        DbFunctions.update(unit);
	        
		}
	}
}
