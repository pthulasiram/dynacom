package com.dynacom.app.domain.services;

import com.dynacom.app.domain.model.Product;

public interface IProductService {

	public abstract Product create(Product product) throws ServiceException;

	public abstract Product update(Product product) throws ServiceException;

}