package com.dynacom.app.domain.model;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.dynacom.app.domain.model.Comment;
import javax.persistence.JoinColumn;

@Entity
public class Signon {
	@Id
	private String userId;
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy="signon")
	private Collection<Contact> contacts = new LinkedHashSet<Contact>();
	@OneToMany
	@JoinColumn(name = "Signon_userId", referencedColumnName = "userId")
	private Collection<Comment> comment;
	
	private Boolean admin;

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
}
