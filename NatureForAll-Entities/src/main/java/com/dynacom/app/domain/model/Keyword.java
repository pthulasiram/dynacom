package com.dynacom.app.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.dynacom.app.domain.model.Product;
import java.util.Collection;
import javax.persistence.ManyToMany;

@Entity
public class Keyword {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String key;

	@ManyToMany(mappedBy = "keyword")
	private Collection<Product> product;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

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

	public Collection<Product> getProduct() {
	    return product;
	}

	public void setProduct(Collection<Product> param) {
	    this.product = param;
	}
}
