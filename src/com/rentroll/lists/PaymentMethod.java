package com.rentroll.lists;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

@Table(name= "PaymentMethod")
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String paymentMethod;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public PaymentMethod(){}
	
	public PaymentMethod(String paymentMethod){
		this.paymentMethod = paymentMethod;
	}
    
    
}
