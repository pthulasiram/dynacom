package com.dynacom.app.domain.model;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String mail;
	@Column(nullable = false)
	private String civility;
	@Transient
	private String confirmMail;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy = "customer")
	private Collection<PurchaseOrder> orders = new LinkedHashSet<PurchaseOrder>();
	
	@ManyToOne
	@JoinColumn(name="signon_id")
	private Signon signon;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the civility
	 */
	public String getCivility() {
		return civility;
	}

	/**
	 * @param civility
	 *            the civility to set
	 */
	public void setCivility(String civility) {
		this.civility = civility;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the orders
	 */
	public Collection<PurchaseOrder> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(Collection<PurchaseOrder> orders) {
		this.orders = orders;
	}

	/**
	 * @return the signon
	 */
	public Signon getSignon() {
		return signon;
	}

	/**
	 * @param signon the signon to set
	 */
	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public String getConfirmMail() {
		return confirmMail;
	}

	public void setConfirmMail(String confirmMail) {
		this.confirmMail = confirmMail;
	}
}
