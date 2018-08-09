package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.ProfileBean;

public interface ProfileDao {
	String createProfile(ProfileBean profileBean);
	int deleteProfile(ArrayList<String> userIDs);
	boolean updateProfile(ProfileBean profileBean);
	ProfileBean findByID(String userID);
	ArrayList<ProfileBean> findAll();
	
}
