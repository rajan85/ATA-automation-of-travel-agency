package com.ata.services;

import java.sql.Date;
import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.ReservationDao;
import com.ata.dao.ReservationDaoImpl;
import com.ata.dao.RouteDao;
import com.ata.dao.RouteDaoImpl;
import com.ata.dao.VehicleDao;
import com.ata.dao.VehicleDaoImpl;

public class CustomerImpl implements Customer {
	private boolean isvalid;
	@Override
	public ArrayList<VehicleBean> viewVehiclesByType(String vehicleType) {
		VehicleDao vehicleDao  = new VehicleDaoImpl();
		if(vehicleType!=null)
		{
			return vehicleDao.findByType(vehicleType);
			
		}
		else 
		return null;
	}

	@Override
	public ArrayList<VehicleBean> viewVehiclesBySeats(int noOfSeats) {
		VehicleDao vehicleDao  = new VehicleDaoImpl();
		if(noOfSeats >0 && noOfSeats<999)
		{
			return vehicleDao.findBySeats(noOfSeats);
		}
		else 
		return null;
	}

	@Override
	public ArrayList<RouteBean> viewAllRoutes() {
		RouteDao routeDao = new RouteDaoImpl();
		ArrayList<RouteBean> allRoutes = routeDao.findAll();
		if(allRoutes != null)
		return allRoutes;
		else 
		return null;
	}

	@Override
	public String bookVehicle(ReservationBean reservationBean) {
		isvalid = false;
		ReservationDao rd = new ReservationDaoImpl();
		String reservationID = reservationBean.getReservationID();
		String userID = reservationBean.getUserID();
		String vehicleID = reservationBean.getvehicleID();
		String routeID = reservationBean.getRouteID();
		Date bookDate = reservationBean.getBookingDate();
		Date journeyDate = reservationBean.getJourneyDate();
		String bPoint = reservationBean.getBoardingPoint();
		double totalFare = reservationBean.getTotalFare();
		String dPoint = reservationBean.getdroppingpoint();
		if(reservationID!=null && userID!=null && vehicleID !=null && routeID!=null && bookDate!=null && journeyDate!=null && bPoint!=null && dPoint!=null && totalFare>0 )
		{
			if(reservationID.matches("(\\w){2}(\\d){4}") && userID.matches("(\\w){2}(\\d){4}") && vehicleID.matches("(\\w){2}(\\d){4}") && routeID.matches("(\\w){4}(\\d){4}")  && bPoint.length()<=30 && dPoint.length()<=30 && totalFare <=9999999999.0)
			{
				isvalid = true;
			}
		}
		if(isvalid)
		{
			return rd.createReservation(reservationBean);
		}
		else
		return null;
	}

	@Override
	public boolean cancelBooking(String userID, String reservationID) {
		ReservationDao reservationDao = new ReservationDaoImpl();
		ArrayList<String> res = new ArrayList<String>();
		int result=0;
		if(userID.matches("(\\w){2}(\\d){4}") && reservationID.matches("(\\w){2}(\\d){4}"))
		{
			res.add(reservationID);
			result = reservationDao.deleteReservation(res);
		}
		if(result>0)
			return true;
		else
		return false;
	}

	@Override
	public ReservationBean viewBookingDetails(String reservationID) {
		ReservationDao reservationDao = new ReservationDaoImpl();
		if(reservationID.matches("(\\w){2}(\\d){4}"))
		{
			return reservationDao.findByID(reservationID);
		}
		else
		return null;
	}

	@Override
	public ReservationBean printBookingDetails(String reservationID) {
		ReservationDao reservationDao = new ReservationDaoImpl();
		if(reservationID.matches("(\\w){2}(\\d){4}"))
		{
			return reservationDao.findByID(reservationID);
		}
		else
		return null;
	}

}
