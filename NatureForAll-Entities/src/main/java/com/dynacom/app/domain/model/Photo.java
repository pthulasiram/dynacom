package com.dynacom.app.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.dynacom.app.domain.model.Photo;
import javax.persistence.OneToOne;

@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String path;
	private String title;
	private PhotoType type;
	
	@ManyToOne
	private Product product;
	@OneToOne
	private Photo photo;
	@OneToOne(mappedBy = "photo")
	private Photo photoBig;
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the type
	 */
	public PhotoType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(PhotoType type) {
		this.type = type;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	public Photo getPhoto() {
	    return photo;
	}
	public void setPhoto(Photo param) {
	    this.photo = param;
	}
	public Photo getPhotoBig() {
	    return photoBig;
	}
	public void setPhotoBig(Photo param) {
	    this.photoBig = param;
	}
}
