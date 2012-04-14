package com.dynacom.app.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dynacom.app.domain.dao.GenericDAO;
import com.dynacom.app.domain.model.Contact;
import com.dynacom.app.domain.services.ContactException;
import com.dynacom.app.domain.services.IContactService;
import com.dynacom.app.domain.services.ServiceException;
import com.dynacom.app.domain.services.ServiceException.ErrorType;

@Service
public class ContactService implements IContactService {
	@Autowired
	private GenericDAO<Contact, Long> contactDao;
	
	/* (non-Javadoc)
	 * @see com.dynacom.app.domain.services.impl.IContactService#createContact(com.dynacom.app.domain.model.Contact)
	 */
	@Override
	@Transactional
	public Contact createContact(Contact contact) throws ServiceException {
		if(contact == null) {
			throw new ContactException(ErrorType.NULL_CONTACT);
		}
		if(!contact.getMail().equals(contact.getConfirmMail())) {
			throw new ContactException(ErrorType.INVALID_MAIL);
		}
		if(contact.getAddress() == null) {
			throw new ContactException(ErrorType.NULL_ADDRESS);
		}
		contactDao.persist(contact);
		return contact;
	}
}
