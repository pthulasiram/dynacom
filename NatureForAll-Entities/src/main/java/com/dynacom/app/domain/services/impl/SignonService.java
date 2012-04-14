package com.dynacom.app.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dynacom.app.domain.dao.GenericDAO;
import com.dynacom.app.domain.model.Contact;
import com.dynacom.app.domain.model.Signon;
import com.dynacom.app.domain.services.IContactService;
import com.dynacom.app.domain.services.ISignonService;
import com.dynacom.app.domain.services.ServiceException;
import com.dynacom.app.domain.services.SignonException;
import com.dynacom.app.domain.services.ServiceException.ErrorType;

@Service
public class SignonService implements ISignonService {
	
	@Autowired
	private GenericDAO<Signon, String> signonDao;
	@Autowired
	private IContactService contactService;
	
	/* (non-Javadoc)
	 * @see com.dynacom.app.domain.services.impl.ISignonService#logon(com.dynacom.app.domain.model.Signon)
	 */
	@Override
	public  Signon logon(Signon signon) throws ServiceException {
		Signon bdSignon = signonDao.find(signon.getUserId());
		if(bdSignon.getActive() != null && bdSignon.getActive().equals(Boolean.FALSE)) {
			throw new SignonException(ErrorType.USER_BLOCKED);
		}
		if(bdSignon != null && bdSignon.getPassword().equals(signon.getPassword())) {
			return bdSignon;
		}
		throw new SignonException(ErrorType.INVALID_USER);
		
	}
	
	/* (non-Javadoc)
	 * @see com.dynacom.app.domain.services.impl.ISignonService#registerUser(com.dynacom.app.domain.model.Signon)
	 */
	@Override
	@Transactional
	public Signon registerUser(Signon signon) throws ServiceException {
		if(signon == null) {
			throw new SignonException(ErrorType.NULL_SIGNON);
		}
		if(signon.getContacts() == null || signon.getContacts().size() == 0) {
			throw new SignonException(ErrorType.NULL_CONTACT);
		}
		if(signon.getPassword() == null) {
			throw new SignonException(ErrorType.NULL_PASSWORD);
		}
		if(!signon.getPassword().equals(signon.getConfirmPassword())) {
			throw new SignonException(ErrorType.PASSWORD_MATCH);
		}
		
		Contact contact = signon.getContacts().iterator().next();
		if(!contact.getMail().equals(contact.getConfirmMail())) {
			throw new SignonException(ErrorType.MAIL_MATCH);
		}
		
		signon.setActive(Boolean.TRUE);
		
		signonDao.persist(signon);
		
		contactService.createContact(contact);
		
		return signon;
	}
}
