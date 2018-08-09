package com.ata.services;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

public interface Customer {
	ArrayList<VehicleBean> viewVehiclesByType(String vehicleType);		//tested
	ArrayList<VehicleBean> viewVehiclesBySeats(int noOfSeats);			//tested
	ArrayList<RouteBean> viewAllRoutes();								//tested	
	String bookVehicle(ReservationBean reservationBean);		
	boolean cancelBooking(String userID , String reservationID);
	ReservationBean viewBookingDetails(String reservationID);
	ReservationBean printBookingDetails(String reservationID);
}	
