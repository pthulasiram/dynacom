package com.dynacom.app.domain.services;

public class SignonException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4261834631365018701L;

	public SignonException(ErrorType type) {
		super(type.name());
		errorType = type;
	}

}
