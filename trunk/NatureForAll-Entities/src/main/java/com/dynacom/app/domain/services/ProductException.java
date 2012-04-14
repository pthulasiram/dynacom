package com.dynacom.app.domain.services;

public class ProductException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4209897818891315878L;

	public ProductException(ErrorType type) {
		super(type.name());
		errorType = type;
	}
}
