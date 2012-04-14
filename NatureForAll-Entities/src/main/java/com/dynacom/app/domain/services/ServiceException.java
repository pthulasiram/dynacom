package com.dynacom.app.domain.services;

import java.util.ResourceBundle;

public abstract class ServiceException extends Exception {
	
	private final ResourceBundle res = ResourceBundle.getBundle("serviceExceptionsBundle");

	protected ErrorType errorType;

	public enum ErrorType {
		INVALID_USER, USER_BLOCKED, USER_EXIST, NULL_SIGNON, NULL_CONTACT, NULL_PASSWORD, PASSWORD_MATCH, MAIL_MATCH, INVALID_MAIL, NULL_ADDRESS, NULL_PRODUCT, NULL_PHOTO
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceException()
	{
		super();
	}
	
	public ServiceException(String name) {
		super(name);
	}

	public ErrorType getErrorType() {
		return errorType;
	}
	
	public String getErrorMessage()
	{
		return res.getString(errorType.name());
	}

}
