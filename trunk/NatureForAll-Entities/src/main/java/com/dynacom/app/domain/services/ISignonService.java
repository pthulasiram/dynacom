package com.dynacom.app.domain.services;

import com.dynacom.app.domain.model.Signon;

public interface ISignonService {

	public abstract Signon logon(Signon signon) throws ServiceException;

	public abstract Signon registerUser(Signon signon) throws ServiceException;

}