package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.ata.bean.VehicleBean;
import com.ata.util.DBUtil;

public class VehicleDaoImpl implements VehicleDao{
	private Connection con = DBUtil.getConnectio();
	@Override
	public String createVehicle(VehicleBean vehicleBean) {
		String id = getVehicleId(vehicleBean.getName().substring(0,2));
		try {
			PreparedStatement ps = con.prepareStatement("insert into ata_tbl_Vehicle values(?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, vehicleBean.getName());
			ps.setString(3, vehicleBean.getType());
			ps.setString(4, vehicleBean.getRegistrationNumber());
			ps.setInt(5, vehicleBean.getSeatingCapacity());
			ps.setDouble(6, vehicleBean.getFarePerKM());
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return id;
			}
				else 
				return "FAIL";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "FAIL";
		}
	}

	@Override
	public int deleteVehicle(ArrayList<String> vehicleIDs) {
		int count=0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from ata_tbl_vehicle where VEHICLEID  = ?");
			for(int i=0;i<vehicleIDs.size();i++)
			{
				ps.setString(1, vehicleIDs.get(i));
				
				if(ps.executeUpdate()>0)
				{
					count++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean updateVehicle(VehicleBean vehicleBean) {
		boolean flag =false;
		try {
			PreparedStatement ps = con.prepareStatement("update ata_tbl_vehicle set VEHICLEID=?, NAME=?, TYPE=?, REGISTRATIONNUMBER=?, SEATINGCAPACITY=?, FAREPERKM=?");
			ps.setString(1, vehicleBean.getVehicleID());
			ps.setString(2, vehicleBean.getName());
			ps.setString(3, vehicleBean.getType());
			ps.setString(4, vehicleBean.getRegistrationNumber());
			ps.setInt(5, vehicleBean.getSeatingCapacity());
			ps.setDouble(6, vehicleBean.getFarePerKM());
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
	public VehicleBean findByID(String vehicleID) {
		VehicleBean vehicleBean = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from ata_tbl_vehicle where VEHICLEID= ?");
			ps.setString(1, vehicleID);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmt = rs.getMetaData();
			System.out.println(rsmt.getColumnCount()+"\t"+rsmt.getColumnTypeName(4));
			if(rs.next())
			{
				vehicleBean = new VehicleBean();
			vehicleBean.setVehicleID(rs.getString(1));
			vehicleBean.setName(rs.getString(2));
			vehicleBean.setType(rs.getString(3));
			vehicleBean.setRegistrationNumber(rs.getString(4));
			vehicleBean.setSeatingCapacity(rs.getInt(5));
			vehicleBean.setFarePerKM(rs.getDouble(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return vehicleBean;	
		}

	@Override
	public ArrayList<VehicleBean> findAll() {
		ArrayList<VehicleBean> vehicles = new ArrayList<VehicleBean>(); 
		Statement statement;
		try {

		statement = con.createStatement();
		ResultSet rs =  statement.executeQuery("select * from ata_tbl_vehicle");
		while(rs.next())
		{
			VehicleBean vehicleBean = new VehicleBean();
			vehicleBean.setVehicleID(rs.getString(1));
			vehicleBean.setName(rs.getString(2));
			vehicleBean.setType(rs.getString(3));
			vehicleBean.setRegistrationNumber(rs.getString(4));
			vehicleBean.setSeatingCapacity(rs.getInt(5));
			vehicleBean.setFarePerKM(rs.getDouble(6));
		
			vehicles.add(vehicleBean);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return vehicles;
	}

	@Override
	public ArrayList<VehicleBean> findByType(String vehicleType) {
		ArrayList<VehicleBean> vehicles = null; 
		try {
		PreparedStatement ps = con.prepareStatement("select * from ata_tbl_vehicle where TYPE = ?");
		ps.setString(1, vehicleType);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
		vehicles = new ArrayList<VehicleBean>();
		rs.previous();
		while(rs.next())
		{
			VehicleBean vehicleBean = new VehicleBean();
			vehicleBean.setVehicleID(rs.getString(1));
			vehicleBean.setName(rs.getString(2));
			vehicleBean.setType(rs.getString(3));
			vehicleBean.setRegistrationNumber(rs.getString(4));
			vehicleBean.setSeatingCapacity(rs.getInt(5));
			vehicleBean.setFarePerKM(rs.getDouble(6));
			vehicles.add(vehicleBean);
		}
		}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return vehicles;
	}

	@Override
	public ArrayList<VehicleBean> findBySeats(int noOfSeats) {
		ArrayList<VehicleBean> vehicles = null; 
		
		try {

		PreparedStatement ps = con.prepareStatement("select * from ata_tbl_vehicle where SEATINGCAPACITY = ?");
		ps.setInt(1, noOfSeats);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			vehicles = new ArrayList<VehicleBean>();
			rs.previous();
		while(rs.next())
		{
			VehicleBean vehicleBean = new VehicleBean();
			vehicleBean.setVehicleID(rs.getString(1));
			vehicleBean.setName(rs.getString(2));
			vehicleBean.setType(rs.getString(3));
			
			vehicleBean.setRegistrationNumber(rs.getString(4));
			vehicleBean.setSeatingCapacity(rs.getInt(5));
			vehicleBean.setFarePerKM(rs.getDouble(6));
		
			vehicles.add(vehicleBean);
		}
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return vehicles;
		}
	
	@Override
	public String getVehicleId(String prefix) {
		String res= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select vehicle_seq from ata_database.sequences");
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

	/*@Override
	public String getVehicleId(String prefix) {
		String res= null;
		try {
			CallableStatement clb = con.prepareCall("call gen_vehicle_id(?)");
			clb.registerOutParameter(1, java.sql.Types.VARCHAR);
			if(clb.executeUpdate()>0)
			{
				 res = clb.getString(1);	
				 res = prefix+res;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}*/
	
	

}
