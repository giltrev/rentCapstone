package com.rentroll.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name= "ServiceCall")
public class ServiceCall implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int scId;
	@ManyToOne()
	private Unit unit;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date initTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Lob
	@Column(name="serviceCallDetail", length=5000)
	private String serviceCallDetail;
	
	@ManyToMany(targetEntity=Vendor.class)
	private Set<Vendor> vendors;
	private String vendorComments;
	private BigDecimal partsCost;
	private BigDecimal laborCost;
	
	private String status;
	
	@OneToMany(targetEntity=Picture.class)
	private Set <Picture> pictures;
	
	private String reachTime;

	
	
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getServiceCallDetail() {
		return serviceCallDetail;
	}
	public void setServiceCallDetail(String serviceCallDetail) {
		this.serviceCallDetail = serviceCallDetail;
	}

	public BigDecimal getPartsCost() {
		return partsCost;
	}
	public void setPartsCost(BigDecimal partsCost) {
		this.partsCost = partsCost;
	}
	public BigDecimal getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(BigDecimal laborCost) {
		this.laborCost = laborCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public ServiceCall(){}
	
	public ServiceCall(Unit unit, String serviceCallName, String serviceCallDetail, String status , String partsCost , String laborCost){
		this();
		this.unit= unit;
		this.serviceCallDetail= serviceCallDetail;
		this.status= status;
		this.partsCost= new BigDecimal(partsCost);
		this.laborCost=  new BigDecimal(laborCost);
	}
	public Set<Vendor> getVendors() {
		return vendors;
	}
	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}
	public Date getInitTime() {
		return initTime;
	}
	public void setInitTime(Timestamp initTime) {
		this.initTime = initTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getVendorComments() {
		return vendorComments;
	}
	public void setVendorComments(String vendorComments) {
		this.vendorComments = vendorComments;
	}
	public Set<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}
	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getReachTime() {
		return reachTime;
	}
	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}

	
	
}
