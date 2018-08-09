package com.ata.util;

import com.ata.bean.CredentialsBean;

public interface Authentication {
	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userID);
	boolean changeLoginStatus(CredentialsBean credentialsBean , int loginStatus);
	
}
