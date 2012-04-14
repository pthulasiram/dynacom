package com.dynacom.app.domain.model;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.dynacom.app.domain.model.Comment;
import javax.persistence.JoinColumn;

@Entity
public class Signon {
	@Id
	private String userId;
	@Column(nullable = false)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@OneToMany(mappedBy="signon")
	private Collection<Contact> contacts = new LinkedHashSet<Contact>();
	@OneToMany
	@JoinColumn(name = "Signon_userId", referencedColumnName = "userId")
	private Collection<Comment> comment;
	
	private Boolean admin;
	private Boolean active;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the contacts
	 */
	public Collection<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Collection<Contact> contacts) {
		this.contacts = contacts;
	}

	public Collection<Comment> getComment() {
	    return comment;
	}

	public void setComment(Collection<Comment> param) {
	    this.comment = param;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
