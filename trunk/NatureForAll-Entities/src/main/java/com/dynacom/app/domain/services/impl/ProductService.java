package com.dynacom.app.domain.services.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.dynacom.app.domain.dao.GenericDAO;
import com.dynacom.app.domain.model.Photo;
import com.dynacom.app.domain.model.Product;
import com.dynacom.app.domain.services.IProductService;
import com.dynacom.app.domain.services.ProductException;
import com.dynacom.app.domain.services.ServiceException;
import com.dynacom.app.domain.services.ServiceException.ErrorType;

public class ProductService implements IProductService {
	@Autowired
	private GenericDAO<Product, Long> productDao;

	/* (non-Javadoc)
	 * @see com.dynacom.app.domain.services.impl.IProductService#create(com.dynacom.app.domain.model.Product)
	 */
	@Override
	public Product create(Product product) throws ServiceException {
		checkNullProduct(product);

		productDao.persist(product);

		return product;
	}

	private void checkNullProduct(Product product) throws ProductException {
		if (product == null) {
			throw new ProductException(ErrorType.NULL_PRODUCT);
		}
	}

	/* (non-Javadoc)
	 * @see com.dynacom.app.domain.services.impl.IProductService#update(com.dynacom.app.domain.model.Product)
	 */
	@Override
	public Product update(Product product) throws ServiceException {
		checkNullProduct(product);
		
		product.setModified(Calendar.getInstance().getTime());
		
		productDao.persist(product);

		return product;
	}
	
	public Product addPhoto(Product product, Photo photo) throws ServiceException {
		checkNullProduct(product);
		checkNullPhoto(photo);
		return product;
	}

	private void checkNullPhoto(Photo photo) throws ServiceException {
		if(photo == null) {
			throw new ProductException(ErrorType.NULL_PHOTO);
		}
		
	}
}
