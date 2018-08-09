package com.ata.util;

import com.ata.bean.CredentialsBean;
import com.ata.dao.CredentialsDao;
import com.ata.dao.CredentialsDaoImpl;

public class AuthenticationImpl implements Authentication{

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		boolean aSattus= false;
		CredentialsDao cDao = new CredentialsDaoImpl();
		String loggedId = credentialsBean.getUserID();
		String loggedPass = credentialsBean.getPassword();
		
		if(loggedId!=null && loggedPass !=null)
		{
			aSattus = cDao.authenticate(credentialsBean);
		}
		return aSattus;
	}

	@Override
	public String authorize(String userID) {
		String userType = "x";
		CredentialsDao cDao = new CredentialsDaoImpl();
		if(userID != null)
		{
			userType = cDao.authorize(userID);
		}
		
		
		return userType;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		boolean aSattus= false;
		CredentialsDao cDao = new CredentialsDaoImpl();
		String loggedId = credentialsBean.getUserID();
		String loggedPass = credentialsBean.getPassword();
		if(loggedId!=null && loggedPass !=null && ( loginStatus == 0 || loginStatus == 1))
		{
			aSattus = cDao.changeLoginStatus(credentialsBean, loginStatus);
		}
		return aSattus;
	}

}
