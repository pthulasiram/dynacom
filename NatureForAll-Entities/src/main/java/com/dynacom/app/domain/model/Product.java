package com.dynacom.app.domain.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String label;

	private String description;

	private Date created;

	private Date modified;
	
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@OneToMany
	@JoinColumn(name="PHOTO_ID")
	private Collection<Photo> photos = new LinkedHashSet<Photo>();
	
	@OneToMany
	@JoinColumn(name="COMMENT_ID")
	private Collection<Comment> comments = new LinkedHashSet<Comment>();

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
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return the photos
	 */
	public Collection<Photo> getPhotos() {
		return photos;
	}

	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(Collection<Photo> photos) {
		this.photos = photos;
	}

	/**
	 * @return the comments
	 */
	public Collection<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
}