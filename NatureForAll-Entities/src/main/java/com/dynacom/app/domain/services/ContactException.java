package com.dynacom.app.domain.services;

public class ContactException extends ServiceException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1352442733696466456L;
	
	
	public ContactException(ErrorType error) {
		super(error.name());
		errorType = error;
	}
}
