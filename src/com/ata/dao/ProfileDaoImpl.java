package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ata.bean.ProfileBean;
import com.ata.util.DBUtil;

public class ProfileDaoImpl implements ProfileDao {
	private Connection con  = DBUtil.getConnectio();
	@Override
	public String createProfile(ProfileBean profileBean) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into ata_tbl_user_profile values(?,?,?, ?,?,?, ?,?,?, ?,?,?)");
			ps.setString(1, profileBean.getUserid());
			ps.setString(2, profileBean.getFirstName());
			ps.setString(3, profileBean.getLastName());
			ps.setDate(4, profileBean.getDateOfBirth());
			ps.setString(5, profileBean.getGender());
			ps.setString(6, profileBean.getStreet());
			ps.setString(7, profileBean.getLocation());
			ps.setString(8, profileBean.getCity());
			ps.setString(9, profileBean.getState());
			ps.setString(10, profileBean.getPincode());
			ps.setString(11, profileBean.getMobileNo());
			ps.setString(12, profileBean.getEmailID());
			int i = ps.executeUpdate();
			if(i>0)
			{
				return "SUCCESS";
			}
				else 
				return "FAIL";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "FAIL";
		}
		
		
	}

	@Override
	public int deleteProfile(ArrayList<String> userIDs) {
		int count=0;
		try {
			PreparedStatement ps = con.prepareStatement("delete  from ata_tbl_user_profile where USERID  = ?");
			for(int i=0;i<userIDs.size();i++)
			{
				ps.setString(1, userIDs.get(i));
				if(ps.executeUpdate()>0)
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public boolean updateProfile(ProfileBean profileBean) {
		boolean flag =false;
		try {
			PreparedStatement ps = con.prepareStatement("update ata_tbl_user_profile set USERID=?, FIRSTNAME=?, LASTNAME=?, DATEOFBIRTH=?, GENDER=?, STREET=?, LOCATION=?, CITY=?, STATE=?, PINCODE=?, MOBILENO=?, EMAILID=?");
			ps.setString(1, profileBean.getUserid());
			ps.setString(2, profileBean.getFirstName());
			ps.setString(3, profileBean.getLastName());
			ps.setDate(4, profileBean.getDateOfBirth());
			ps.setString(5, profileBean.getGender());
			ps.setString(6, profileBean.getStreet());
			ps.setString(7, profileBean.getLocation());
			ps.setString(8, profileBean.getCity());
			ps.setString(9, profileBean.getState());
			ps.setString(10, profileBean.getPincode());
			ps.setString(11, profileBean.getMobileNo());
			ps.setString(12, profileBean.getEmailID());
			int i =  ps.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	@Override
	public ProfileBean findByID(String userID) {
		ProfileBean profileBean = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from ata_tbl_user_profile where  USERID = ?");
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				profileBean = new ProfileBean();
			profileBean.setUserid(rs.getString(1));
			profileBean.setFirstName(rs.getString(2));
			profileBean.setLastName(rs.getString(3));
			profileBean.setDateOfBirth(rs.getDate(4));
			profileBean.setGender(rs.getString(5));
			profileBean.setStreet(rs.getString(6));
			profileBean.setLocation(rs.getString(7));
			profileBean.setCity(rs.getString(8));
			profileBean.setState(rs.getString(9));
			profileBean.setPincode(rs.getString(10));
			profileBean.setMobileNo(rs.getString(11));
			profileBean.setEmailID(rs.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return profileBean;
	}

	@Override
	public ArrayList<ProfileBean> findAll() {
		ArrayList<ProfileBean> profiles = new ArrayList<ProfileBean>(); 
		Statement statement;
		try {

		statement = con.createStatement();
		ResultSet resultSet =  statement.executeQuery("select * from ata_tbl_user_profile");
		while(resultSet.next())
		{
			ProfileBean profile = new ProfileBean();
			profile.setUserid(resultSet.getString(1));
			profile.setFirstName(resultSet.getString(2));
			profile.setLastName(resultSet.getString(3));
			profile.setDateOfBirth(resultSet.getDate(4));
			profile.setGender(resultSet.getString(5));
			profile.setStreet(resultSet.getString(6));
			profile.setLocation(resultSet.getString(7));
			profile.setCity(resultSet.getString(8));
			profile.setState(resultSet.getString(9));
			profile.setPincode(resultSet.getString(10));
			profile.setMobileNo(resultSet.getString(11));
			profile.setEmailID(resultSet.getString(12));
			profiles.add(profile);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return profiles;
	}

	

}
