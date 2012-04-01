package com.dynacom.app.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date edited;
	
	@OneToOne
	private PurchaseOrder po;
	
//	@ManyToOne
//	private Contact contact;
	
	@ManyToOne
	private Address billingAddress;
	
	@ManyToOne
	private Address mailAddress;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the edited
	 */
	public Date getEdited() {
		return edited;
	}

	/**
	 * @param edited the edited to set
	 */
	public void setEdited(Date edited) {
		this.edited = edited;
	}

	/**
	 * @return the po
	 */
	public PurchaseOrder getPo() {
		return po;
	}

	/**
	 * @param po the po to set
	 */
	public void setPo(PurchaseOrder po) {
		this.po = po;
	}

	
	/**
	 * @return the billingAddress
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the mailAddress
	 */
	public Address getMailAddress() {
		return mailAddress;
	}

	/**
	 * @param mailAddress the mailAddress to set
	 */
	public void setMailAddress(Address mailAddress) {
		this.mailAddress = mailAddress;
	}

	
}
