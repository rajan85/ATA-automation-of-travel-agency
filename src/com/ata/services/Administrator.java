package com.ata.services;

import java.sql.Date;
import java.util.ArrayList;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

public interface Administrator {
		String addVehicle(VehicleBean vehicleBean);			//tested	
		int deleteVehicle(ArrayList<String> vehicleID);		//tested
		VehicleBean viewVehicle(String vehicleID);			//tested
		boolean modifyVehicle(VehicleBean vehicleBean);		//tested
		
		String addDriver(DriverBean driverBean);			//tested
		boolean allotDriver(String reservationID , String driverID);
		boolean modifyDriver(DriverBean driverBean);		//tested
		
		String addRoute(RouteBean routeBean);				//tested
		int deleteRoute(ArrayList<String> routeID);			//tested
		RouteBean viewRoute(String routeID);				//tested
		boolean modifyRoute(RouteBean routeBean);			//tested
		
		ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source ,String destination);
}
