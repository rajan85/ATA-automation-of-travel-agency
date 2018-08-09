package com.ata.util;

import com.ata.bean.CredentialsBean;
import com.ata.dao.CredentialsDao;
import com.ata.dao.CredentialsDaoImpl;

public class UserImpl implements User{

	@Override
	public String login(CredentialsBean credentialsBean) {
		String status = "FAIL";
		boolean success = false;
		Authentication auth = new AuthenticationImpl();
		if(credentialsBean !=null )
		{
			success = auth.authenticate(credentialsBean);
			if(success)
			{
				status = auth.authorize(credentialsBean.getUserID());
				auth.changeLoginStatus(credentialsBean, 1);
			}
			else
			{
				status = "INVALID";
			}
		}
		
		
		return status;
	}

	@Override
	public boolean logout(String UserId) {
		CredentialsBean cBean = new CredentialsBean();
		cBean.setUserID(UserId);
		
		CredentialsDao cDao = new CredentialsDaoImpl();
		boolean status = cDao.changeLoginStatus(cBean, 0);
		
		
		return status;
	}
	@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
		String success = "FAIL";
		Authentication auth = new AuthenticationImpl();
		if(credentialsBean !=null )
		{
			 
			if(auth.authenticate(credentialsBean))
			{
				CredentialsDao cDao = new CredentialsDaoImpl();
				if(cDao.updatePassword(credentialsBean,newPassword))
				{
					success = "SUCCESS";
				}
			}
			else
			{
				success = "INVALID";
			}
		}
		return success;
	}

	@Override
	public String register(CredentialsBean credentialsBean , String prefix) {
		String success = "FAIL";
		CredentialsDao cd = new CredentialsDaoImpl();
		if(credentialsBean != null && prefix != null)
		{
			success = cd.createCredentials(credentialsBean, prefix);
		}
		else {
			success = "INVALID";
		}
		return success;
	}
	

}
