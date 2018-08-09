package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.CredentialsBean;

public interface CredentialsDao {
	String createCredentials(CredentialsBean credentialsBean , String prefix);
	
	boolean updatePassword(CredentialsBean credentialsBean, String newPassword);
	CredentialsBean findByID(String userID);
	ArrayList<CredentialsBean> findAll();
	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userID);
	boolean changeLoginStatus(CredentialsBean credentialsBean , int loginStatus);
	public String getUserId(String prefix);
	//int deleteCredentials(ArrayList<String> userIDs);
	
	
}
 