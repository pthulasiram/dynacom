package com.dynacom.app.domain.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * An order.
 */
@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="customer")
	private Contact customer;
	
	@ManyToOne
	@JoinColumn(name="delivery")
	private Contact delivery;
	
	private Date poDate = new Date();

	@OneToMany(cascade=CascadeType.ALL)
	private Collection<LineItem> lineItems = new LinkedHashSet<LineItem>();
	
	/**
	 * @return the customer
	 */
	public Contact getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Contact customer) {
		this.customer = customer;
	}

	/**
	 * @return the items
	 */
	public Collection<LineItem> getLineItems() {
		return lineItems;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setLineItems(Collection<LineItem> items) {
		this.lineItems = items;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the poDate
	 */
	public Date getPoDate() {
		return poDate;
	}

	/**
	 * @param poDate
	 *            the poDate to set
	 */
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the delivery
	 */
	public Contact getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(Contact delivery) {
		this.delivery = delivery;
	}

}
