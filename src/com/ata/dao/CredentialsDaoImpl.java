package com.ata.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ata.bean.CredentialsBean;
import com.ata.util.DBUtil;
import com.ata.util.Encryption;
import com.ata.util.Encryption.EncryptionException;

public class CredentialsDaoImpl implements CredentialsDao{
	private Connection con = DBUtil.getConnectio();
	@Override
	public String createCredentials(CredentialsBean credentialsBean , String prefix){
		
		String id = getUserId(prefix);
		try {
			final byte[] keyBytes = "0123456789ABCDEF01234567".getBytes("ASCII");
			final byte[] IVBytes = "ABCDEFGH".getBytes("ASCII");
			Encryption encryption = new Encryption(keyBytes, IVBytes);
			PreparedStatement ps = con.prepareStatement("insert into ata_tbl_user_Credentials values(?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, encryption.encrypt(credentialsBean.getPassword()));
			ps.setString(3, "u");
			ps.setInt(4, 0);
			int i = ps.executeUpdate();
			if(i>0)
			{
				System.out.println("id generated is "+id);
				return id;
			}
				else 
				return "FAIL";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EncryptionException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "FAIL";
		
	}

	
	

	@Override
	public boolean updatePassword(CredentialsBean credentialsBean , String newPassword) {
		boolean flag =false;
		try {
			PreparedStatement ps = con.prepareStatement("update ata_tbl_driver  set PASSWORD =? where USERID = ?");
			
			ps.setString(1, newPassword);
			ps.setString(2, credentialsBean.getUserID());
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
	public CredentialsBean findByID(String userID) {
		CredentialsBean credentialsBean = new CredentialsBean();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ata_tbl_credentials where USERID=?");
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			credentialsBean.setUserID(rs.getString(1));
			credentialsBean.setPassword(rs.getString(2));
			credentialsBean.setUserType(rs.getString(3));
			credentialsBean.setLoginStatus(rs.getInt(4));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return credentialsBean;
	}

	@Override
	public ArrayList<CredentialsBean> findAll() {
		ArrayList<CredentialsBean> credentials = new ArrayList<CredentialsBean>(); 
		Statement statement;
		try {

		statement = con.createStatement();
		ResultSet rs =  statement.executeQuery("select * from ata_tbl_credential");
		while(rs.next())
		{
			CredentialsBean credentialsBean = new CredentialsBean();
			credentialsBean.setUserID(rs.getString(1));
			credentialsBean.setPassword(rs.getString(2));
			credentialsBean.setUserType(rs.getString(3));
			credentialsBean.setLoginStatus(rs.getInt(4));
			credentials.add(credentialsBean);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return credentials;

	}

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		boolean aStatus = false;
		String query = "select * from ata_tbl_user_credentials where USERID = ? and PASSWORD = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, credentialsBean.getUserID());
			preparedStatement.setString(2, credentialsBean.getPassword());
			ResultSet result = preparedStatement.executeQuery();
			while(result.next())
			{
				aStatus = true;
			}
			
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return aStatus;
	}

	@Override
	public String authorize(String userID) {
		String userType = "x";
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select USERTYPE from ata_tbl_user_credentials where USERID = ?");
			preparedStatement.setString(1, userID);
			System.out.println(userID);
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next())
			{
				userType = result.getString(1);
			}
			
		} catch (SQLException e) {
			e.getMessage();
			//e.printStackTrace();
		}
		return userType;
	}


	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		boolean success = false;
		String query = "update ata_tbl_driver  set LOGINSTATUS =? where USERID = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, loginStatus);
			preparedStatement.setString(2, credentialsBean.getUserID());
			int i = preparedStatement.executeUpdate();
			if(i>0)
			{
				success=true;
			}
		} catch (SQLException e) {
			e.getMessage();
			//e.printStackTrace();
		}
		
		return success;
	}
	
	@Override
	public String getUserId(String prefix) {
		 String res= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select profile_seq from ata_database.sequences");
			if(rs.next())
			{
				res = ""+rs.getInt(1);
				res = prefix+res;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}
	/*public int deleteCredentials(ArrayList<String> credentialsIDs) {
	int count=0;
	try {
		PreparedStatement ps = con.prepareStatement("delete * from ata_tbl_credentials where USERID  = ?");
		for(int i=0;i<credentialsIDs.size();i++)
		{
			ps.setString(1, credentialsIDs.get(i));
			ps.executeUpdate();
			count++;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return count;
}*/




	

}
