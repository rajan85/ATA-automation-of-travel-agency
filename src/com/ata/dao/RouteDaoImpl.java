package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ata.bean.RouteBean;
import com.ata.util.DBUtil;

public class RouteDaoImpl implements RouteDao{
	private Connection con = DBUtil.getConnectio();
	@Override
	public String createRoute(RouteBean routeBean) {
		String so = routeBean.getSource();
		String des = routeBean.getDestination();
		String id = getRouteId(so.substring(0, 2), des.substring(0, 2));
		try {
			PreparedStatement ps = con.prepareStatement("insert into ata_tbl_Route values(?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, so);
			ps.setString(3, des);
			ps.setInt(4, routeBean.getDistance());
			ps.setDouble(5, routeBean.getTravelDuration());
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
	public int deleteRoute(ArrayList<String> routeIDs) {
		int count=0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from ata_tbl_route where ROUTEID  = ?");
			for(int i=0;i<routeIDs.size();i++)
			{
				ps.setString(1, routeIDs.get(i));
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
	public boolean updateRoute(RouteBean routeBean) {
		boolean flag =false;
		try {
			PreparedStatement ps = con.prepareStatement("update ata_tbl_route set ROUTEID=?, SOURCE=?, DESTINATION=?, DISTANCE=?, TRAVELDURATION=? where  ROUTEID=?");
			ps.setString(1, routeBean.getRouteID());
			ps.setString(2, routeBean.getSource());
			ps.setString(3, routeBean.getDestination());
			ps.setInt(4, routeBean.getDistance());
			ps.setDouble(5, routeBean.getTravelDuration());
			ps.setString(6, routeBean.getRouteID());
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
	public RouteBean findByID(String routeID) {
		RouteBean routeBean =null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from ata_tbl_route where ROUTEID = ?");
			ps.setString(1, routeID);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				routeBean = new RouteBean();
			routeBean.setRouteID(rs.getString(1));
			routeBean.setSource(rs.getString(2));
			routeBean.setDestination(rs.getString(3));
			routeBean.setDistance(rs.getInt(4));
			routeBean.setTravelDuration(rs.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return routeBean;	
		}

	@Override
	public ArrayList<RouteBean> findAll() {
		ArrayList<RouteBean> routes = new ArrayList<RouteBean>(); 
		Statement statement;
		try {

		statement = con.createStatement();
		ResultSet rs =  statement.executeQuery("select * from ata_tbl_route");
		while(rs.next())
		{
			RouteBean routeBean = new RouteBean();
			routeBean.setRouteID(rs.getString(1));
			routeBean.setSource(rs.getString(2));
			routeBean.setDestination(rs.getString(3));
			routeBean.setDistance(rs.getInt(4));
			routeBean.setTravelDuration(rs.getDouble(5));
		
			routes.add(routeBean);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return routes;
	}

	@Override
	public String getRouteId(String sourcePrefix, String destinationPrefix) {
		String res= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select route_seq from ata_database.sequences");
			if(rs.next())
			{
				res = rs.getString(1);
				res = sourcePrefix+destinationPrefix+res;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}

}
