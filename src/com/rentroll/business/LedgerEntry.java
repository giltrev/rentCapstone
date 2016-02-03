package com.rentroll.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Ledger")
public class LedgerEntry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ledgerId;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String accountName;
	private String reference;
	private BigDecimal debit;
	private BigDecimal credit;
	@ManyToOne
	Unit unit;
	
	public int getLedgerId() {
		return ledgerId;
	}
	public void setLedgerId(int ledgerId) {
		this.ledgerId = ledgerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public BigDecimal getDebit() {
		return debit;
	}
	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}
	public BigDecimal getCredit() {
		return credit;
	}
	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public LedgerEntry(){}
	public LedgerEntry(Unit unit,String date, String accountName, 
			String reference, String debit, String credit){
		this();
		this.unit = unit;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		

		try {

			this.date = formatter.parse(date);
			System.out.println(this.date);
			System.out.println(formatter.format(this.date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		this.accountName = accountName;
		this.reference = reference;
		this.credit = new BigDecimal(credit);
		this.debit = new BigDecimal(debit);
	}
	
	
	

}
