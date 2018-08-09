package com.ata.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.util.DBUtil;

public  class  ReservationDaoImpl implements ReservationDao{
	private Connection con  = DBUtil.getConnectio();

	@Override
	public String createReservation(ReservationBean reservationBean) {
		String id = getReservationId();
		try {
			PreparedStatement ps = con.prepareStatement("insert into ata_tbl_Reservation values(?,?,?, ?,?,?, ?,?)");
			ps.setString(1, id);
			ps.setString(2, reservationBean.getUserID());
			ps.setString(3, reservationBean.getvehicleID());
			ps.setString(4, reservationBean.getRouteID());
			ps.setDate(5, reservationBean.getBookingDate());
			ps.setDate(6, reservationBean.getJourneyDate());
			ps.setString(7, "waiting");
			ps.setDouble(8, reservationBean.getTotalFare());
			ps.setString(9, reservationBean.getBoardingPoint());
			ps.setString(10, reservationBean.getdroppingpoint());
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				return id;
			}
				else 
				return "FAIL";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	@Override
	public String confirmReservation(String reservationID, String driverID) {
		try {
			PreparedStatement ps = con.prepareStatement("update ata_tbl_reservation set DRIVERID = ? , BOOKINGSTATUS = ?");
			ps.setString(1, driverID);
			ps.setString(2, reservationID);
			int i = ps.executeUpdate();
			if(i>0)
			{
				return "Reservation sucessfully registered";
			}
				else 
				return "Reservation not registered..........some problem occured";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Reservation not registered..........some problem occured";
		}
		
	}

	@Override
	public int deleteReservation(ArrayList<String> reservationIDs) {
		int count=0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from ata_tbl_reservation where USERID  = ?");
			for(int i=0;i<reservationIDs.size();i++)
			{
				ps.setString(1, reservationIDs.get(i));
				if(ps.executeUpdate()>0)
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;

	}

	@Override
	public boolean updateReservation(ReservationBean reservationBean) {
		boolean flag =false;
		try {
			PreparedStatement ps = con.prepareStatement("update ata_tbl_driver set RESERVATIONID=?, DROPPINGPOINT=?, VEHICLEID=?, ROUTEID=?, BOOKINGDATE=?, JOURNEYDATE=?, DRIVERID=?, BOOKINGSTATUS=?, TOTALFARE=?, BROADINGPOINT=? ");
			ps.setString(1, reservationBean.getReservationID());
			ps.setString(2, reservationBean.getdroppingpoint());
			ps.setString(3, reservationBean.getvehicleID());
			ps.setString(4, reservationBean.getRouteID());
			ps.setDate(5, reservationBean.getBookingDate());
			ps.setDate(6, reservationBean.getJourneyDate());
			ps.setString(7, reservationBean.getDriverID());
			ps.setString(8, reservationBean.getBookingStatus());
			ps.setDouble(9, reservationBean.getTotalFare());
			ps.setString(10, reservationBean.getBoardingPoint());
			
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
	public ReservationBean findByID(String reservationID) {
		ReservationBean reservationBean = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from ata_tbl_reservation where  RESERVATIONID = ?");
			ps.setString(1, reservationID);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
			reservationBean.setReservationID(getReservationId());
			reservationBean.setUserID(rs.getString(2));
			reservationBean.setvehicleID(rs.getString(3));
			reservationBean.setRouteID(rs.getString(4));
			reservationBean.setBookingDate(rs.getDate(5));
			reservationBean.setJourneyDate(rs.getDate(6));
			reservationBean.setDriverID(rs.getString(7));
			reservationBean.setBookingStatus(rs.getString(8));
			reservationBean.setTotalFare(rs.getDouble(9));
			reservationBean.setBoardingPoint(rs.getString(10));
			reservationBean.setdroppingpoint(rs.getString(11));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return reservationBean;
	}

	@Override
	public ArrayList<ReservationBean> findAll() {
		ArrayList<ReservationBean> reservations = new ArrayList<ReservationBean>(); 
		Statement statement;
		try {

		statement = con.createStatement();
		ResultSet rs =  statement.executeQuery("select * from ata_tbl_reservation");
		while(rs.next())
		{
			ReservationBean reservationBean = new ReservationBean();
			reservationBean.setReservationID(rs.getString(1));
			reservationBean.setUserID(rs.getString(2));
			reservationBean.setvehicleID(rs.getString(3));
			reservationBean.setRouteID(rs.getString(4));
			reservationBean.setBookingDate(rs.getDate(5));
			reservationBean.setJourneyDate(rs.getDate(6));
			reservationBean.setDriverID(rs.getString(7));
			reservationBean.setBookingStatus(rs.getString(8));
			reservationBean.setTotalFare(rs.getDouble(9));
			reservationBean.setBoardingPoint(rs.getString(10));
			reservationBean.setdroppingpoint(rs.getString(11));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return reservations;
	}
	
	public ArrayList<ReservationBean> findAllByJourney(Date journeyDate, String source, String destination)
	{
		ArrayList<ReservationBean> reservations = new ArrayList<ReservationBean>();
		PreparedStatement ps ;
		try {

		ps = con.prepareStatement("select * from ata_tbl_reservation where JOURNEYDATE = ? AND BROADINGPOINT = ? AND DROPPINGPOINT = ?");
		ps.setDate(1, journeyDate);
		ps.setString(2,source);
		ps.setString(3, destination);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			ReservationBean reservationBean = new ReservationBean();
			reservationBean.setReservationID(rs.getString(1));
			reservationBean.setUserID(rs.getString(2));
			reservationBean.setvehicleID(rs.getString(3));
			reservationBean.setRouteID(rs.getString(4));
			reservationBean.setBookingDate(rs.getDate(5));
			reservationBean.setJourneyDate(rs.getDate(6));
			reservationBean.setDriverID(rs.getString(7));
			reservationBean.setBookingStatus(rs.getString(8));
			reservationBean.setTotalFare(rs.getDouble(9));
			reservationBean.setBoardingPoint(rs.getString(10));
			reservationBean.setdroppingpoint(rs.getString(11));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return reservations;
		
	}

	@Override
	public String getReservationId() {
		String res= null;
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select reservation_seq from ata_database.sequences");
			if(rs.next())
			{
				res = rs.getString(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
	}

	
}
