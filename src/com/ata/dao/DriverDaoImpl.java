package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ata.bean.DriverBean;
import com.ata.util.DBUtil;

public class DriverDaoImpl implements DriverDao{
	private Connection con  = DBUtil.getConnectio();

	@Override
	public String createDriver(DriverBean driverBean) {
		String id = getDriverId(driverBean.getName().substring(0, 2));
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into ata_tbl_Driver values(?,?,?, ?,?,?, ?,?,?)");
			ps.setString(1, id);
			ps.setString(2, driverBean.getName());
			ps.setString(3, driverBean.getStreet());
			ps.setString(4, driverBean.getLocation());
			ps.setString(5, driverBean.getCity());
			ps.setString(6, driverBean.getState());
			ps.setString(7, driverBean.getPincode());
			ps.setString(8, driverBean.getMobileNo());
			ps.setString(9, driverBean.getLicenseNumber());
			int i = ps.executeUpdate();
			if(i>0)
			{
				return "SUCCESS";
			}
				else 
					System.out.println("44444444444444");
				return "FAIL";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "FAIL";
		}
		
	}

	@Override
	public int deleteDriver(ArrayList<String> driverIDs) {
		int count=0;
		try {
			PreparedStatement ps = con.prepareStatement("delete  from ata_tbl_driver where USERID  = ?");
			for(int i=0;i<driverIDs.size();i++)
			{
				ps.setString(1, driverIDs.get(i));
				if(ps.executeUpdate()>0)
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;

	}

	@Override
	public boolean updateDriver(DriverBean driverBean) {
		boolean flag =false;
		try {
			PreparedStatement ps = con.prepareStatement("update ata_tbl_driver set DRIVERID=?, NAME=?, STREET=?, LOCATION=?, CITY=?, STATE=?, PINCODE=?, MOBILENO=?, LICENSENUMBER=? where DRIVERID = ?");
			ps.setString(1, driverBean.getDriverID());
			ps.setString(2, driverBean.getName());
			ps.setString(3, driverBean.getStreet());
			ps.setString(4, driverBean.getLocation());
			ps.setString(5, driverBean.getCity());
			ps.setString(6, driverBean.getState());
			ps.setString(7, driverBean.getPincode());
			ps.setString(8, driverBean.getMobileNo());
			ps.setString(9, driverBean.getLicenseNumber());
			ps.setString(10, driverBean.getDriverID());
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
	public DriverBean findByID(String driverID) {
		DriverBean driverBean = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from ata_tbl_driver where  DRIVERID = ?");
			ps.setString(1, driverID);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				driverBean = new DriverBean();
			driverBean.setDriverID(rs.getString(1));
			driverBean.setName(rs.getString(2));
			driverBean.setStreet(rs.getString(3));
			driverBean.setLocation(rs.getString(4));
			driverBean.setCity(rs.getString(5));
			driverBean.setState(rs.getString(6));
			driverBean.setPincode(rs.getString(7));
			driverBean.setMobileNo(rs.getString(8));
			driverBean.setLicenseNumber(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return driverBean;
	}

	@Override
	public ArrayList<DriverBean> findAll() {
		ArrayList<DriverBean> drivers = new ArrayList<DriverBean>(); 
		Statement statement;
		try {

		statement = con.createStatement();
		ResultSet rs =  statement.executeQuery("select * from ata_tbl_driver");
		while(rs.next())
		{
			DriverBean driverBean = new DriverBean();
			driverBean.setDriverID(rs.getString(1));
			driverBean.setName(rs.getString(2));
			driverBean.setStreet(rs.getString(3));
			driverBean.setLocation(rs.getString(4));
			driverBean.setCity(rs.getString(5));
			driverBean.setState(rs.getString(6));
			driverBean.setPincode(rs.getString(7));
			driverBean.setMobileNo(rs.getString(8));
			driverBean.setLicenseNumber(rs.getString(9));
			drivers.add(driverBean);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return drivers;
	}

	@Override
	public String getDriverId(String prefix) {
		String res= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select driver_seq from ata_database.sequences");
			if(rs.next())
			{
				res = rs.getString(1);
				res = prefix+res;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}
	
	
}

