package com.dynacom.app.domain.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;

public interface GenericDAO<T, PK extends Serializable> {

	/** 
	 * Persist the newInstance object into database 
	 * 
	 */
	void persist(T newInstance);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	T find(PK id);

	/** 
	 * Remove an object from persistent storage in the database 
	 */
	void remove(T persistentObject);

	/**
	 * Returns all records.
	 * 
	 * @return
	 */
	Collection<T> findAll();
	
	void flush();
	
	void clear();
	
	EntityManager getEntityManager();
}
