package com.dynacom.app.domain.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository(value = "genericDAO")
public class GenericDAOImpl<T, PK extends Serializable> implements
		GenericDAO<T, PK> {
	private Class<T> type;

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}

	@PersistenceContext
	private EntityManager entityManager;

	public void remove(T entity) {
		entityManager.remove(entity);
	}

	public T find(PK id) {
		return entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findAll() {
		return entityManager.createQuery(
				"select o from " + type.getName()).getResultList();
	}

	public void persist(T newInstance) {
		entityManager.persist(newInstance);
	}

	public void flush() {
		entityManager.flush();
	}

	public void clear() {
		entityManager.clear();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
