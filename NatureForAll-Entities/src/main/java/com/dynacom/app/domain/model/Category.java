package com.dynacom.app.domain.model;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String label;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Category owner;

	@OneToMany(mappedBy="owner")
	private Collection<Category> owned = new LinkedHashSet<Category>();
	
	@OneToMany(mappedBy="category")
	private Collection<Product> products = new LinkedHashSet<Product>();

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
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the owner
	 */
	public Category getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(Category owner) {
		this.owner = owner;
	}

	/**
	 * @return the owned
	 */
	public Collection<Category> getOwned() {
		return owned;
	}

	/**
	 * @param owned
	 *            the owned to set
	 */
	public void setOwned(Collection<Category> owned) {
		this.owned = owned;
	}

	/**
	 * @return the products
	 */
	public Collection<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
}
