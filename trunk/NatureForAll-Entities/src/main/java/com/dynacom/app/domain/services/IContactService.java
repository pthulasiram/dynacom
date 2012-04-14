package com.dynacom.app.domain.services;

import org.springframework.transaction.annotation.Transactional;

import com.dynacom.app.domain.model.Contact;

public interface IContactService {

	@Transactional
	public abstract Contact createContact(Contact contact)
			throws ServiceException;

}