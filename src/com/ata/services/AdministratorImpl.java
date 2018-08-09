package com.ata.services;

import java.sql.Date;
import java.util.ArrayList;


import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.DriverDao;
import com.ata.dao.DriverDaoImpl;
import com.ata.dao.ReservationDao;
import com.ata.dao.ReservationDaoImpl;
import com.ata.dao.RouteDao;
import com.ata.dao.RouteDaoImpl;
import com.ata.dao.VehicleDao;
import com.ata.dao.VehicleDaoImpl;

public class AdministratorImpl implements Administrator{
	 private boolean isValid = false;
	@Override
	public String addVehicle(VehicleBean vehicleBean) {
		VehicleDao vehicleDao = new VehicleDaoImpl();
		String vehicleName = vehicleBean.getName();
		String type = vehicleBean.getType();
		String regNum = vehicleBean.getRegistrationNumber();
		int sCap = vehicleBean.getSeatingCapacity();
		double fpKM= vehicleBean.getFarePerKM();
		if(vehicleName != null  && type !=null && regNum !=null )
		if( vehicleName.length()<=20  && type.length() <=8 && regNum.length()<= 12 && sCap >=1 && sCap <=999 && fpKM >=0.0 && fpKM <=999.0)
		{
			isValid = true;
		}
		if(isValid)
		{
		return vehicleDao.createVehicle(vehicleBean);
		}
		else return "INVALID";
	}
	
	
	
	@Override
	public int deleteVehicle(ArrayList<String> vehicleIDs) {
		VehicleDao vehicleDao = new VehicleDaoImpl();
		for(int i=0;i<vehicleIDs.size();i++)
		{
			if(vehicleIDs.get(i).matches("(\\w){2}(\\d){4}"))
			{
				
				isValid = true;
			}
		}
		if(isValid)
		{
			
			return vehicleDao.deleteVehicle(vehicleIDs);
		}
		else 
		{
			
		return 0;
		}
	}

	@Override
	public VehicleBean viewVehicle(String vehicleID) {
		VehicleDao vehicleDao = new VehicleDaoImpl();
		if(vehicleID!=null  &&vehicleID.matches("(\\w){2}(\\d){4}") )
		return vehicleDao.findByID(vehicleID);
		else 
			return null;
	}

	@Override
	public boolean modifyVehicle(VehicleBean vehicleBean) {
		
		if(vehicleBean!=null)
		{
		String vehicleName = vehicleBean.getName();
		String vehicleID = vehicleBean.getVehicleID();
		String type = vehicleBean.getType();
		String regNum = vehicleBean.getRegistrationNumber();
		int sCap = vehicleBean.getSeatingCapacity();
		double fpKM= vehicleBean.getFarePerKM();
		
		if(vehicleName != null && vehicleID != null && type !=null && regNum !=null )
		if( vehicleName.length()<=20   && vehicleID.matches(vehicleName.substring(0,2)+"(\\d){4}") && type.length() <=8 && regNum.length()<= 12 && sCap >=1 && sCap <=999 && fpKM >=0.0 && fpKM <=999.0)
		{
			isValid = true;
		}
		if(isValid)
		{
			VehicleDao vehicleDao = new VehicleDaoImpl();
			return vehicleDao.updateVehicle(vehicleBean);
		}
		}
		
		return isValid;
	}

	@Override
	public String addDriver(DriverBean driverBean) {
		DriverDao dDao = new DriverDaoImpl();
		String dName = driverBean.getName();
		String street = driverBean.getStreet();
		String loc = driverBean.getLocation();
		String city = driverBean.getCity();
		String state  = driverBean.getState();
		String pc = driverBean.getPincode();
		String mNum = driverBean.getMobileNo();
		String lNum = driverBean.getLicenseNumber();
		if( dName != null && street !=null && loc != null && city != null && state != null && pc != null && mNum != null && lNum != null)
		if(dName.length()<=25 && street.length()<=30 && loc.length()<=15 && city.length() <=15 && state.length() <=15 && pc.length() <=6 && mNum.length() <= 10 && lNum.length() <=20)
		{
			System.out.println("33333333333333");
			isValid = true;
		}
		if(isValid)
		{
			dDao.createDriver(driverBean);
			return "SUCCESS";
		}
		else
		return "INVALID";
	}

	@Override
	public boolean allotDriver(String reservationID, String driverID) {
		ReservationDao rd = new ReservationDaoImpl();
		if(reservationID.matches("(\\w){2}(\\d){4}") && driverID.matches("(\\w){2}(\\d){4}"))
		{
			rd.confirmReservation(reservationID, driverID);
			return true;
		}
		else
		return false;
	}

	@Override
	public boolean modifyDriver(DriverBean driverBean) {
		if(driverBean!=null)
		{
		String dID = driverBean.getDriverID();
		String dName = driverBean.getName();
		String street = driverBean.getStreet();
		String loc = driverBean.getLocation();
		String city = driverBean.getCity();
		String state  = driverBean.getState();
		String pc = driverBean.getPincode();
		String mNum = driverBean.getMobileNo();
		String lNum = driverBean.getLicenseNumber();
		
		if(dID != null && dName != null && street !=null && loc != null && city != null && state != null && pc != null && mNum != null && lNum != null)
		if(dName.length()<=25 && dID.matches(dName.substring(0, 2)+"(\\d){4}") && street.length()<=30 && loc.length()<=15 && city.length() <=15 && state.length() <=15 && pc.length() <=6 && mNum.length() <= 10 && lNum.length() <=20)
		{
			isValid = true;
		}
		if(isValid)
		{
			DriverDao dDao = new DriverDaoImpl();
			return dDao.updateDriver(driverBean);
			
		}
		}
		return isValid;
		
	}

	@Override
	public String addRoute(RouteBean routeBean) {
		RouteDao routeDao = new RouteDaoImpl();
		String src = routeBean.getSource();
		String dst = routeBean.getDestination();
		int dis = routeBean.getDistance();
		double dur = routeBean.getTravelDuration();
		if(src!=null && dst != null && dis >0 && dur >0)
		if(src.length()<=20 &&  dis <=9999 && dur <=999.0)
		{
			isValid = true;
		}
		if(isValid)
		{
			return routeDao.createRoute(routeBean);
		}
		return "INVALID";
	}

	@Override
	public int deleteRoute(ArrayList<String> routeID) {
		RouteDao routeDao = new RouteDaoImpl();
		for(int i=0;i<routeID.size();i++)
		{
			if(routeID.get(i).matches("(\\w){4}(\\d){4}"))
			{
				isValid = true;
			}
		}
		if(isValid)
		{
			return routeDao.deleteRoute(routeID);
		}
		else
		return 0;
	}

	@Override
	public RouteBean viewRoute(String routeID) {
		RouteDao routeDao = new RouteDaoImpl();
		if(routeID.matches("(\\w){4}(\\d){4}") && routeID!=null)
		{
			return routeDao.findByID(routeID);
		}
		else
		return null;
	}

	@Override
	public boolean modifyRoute(RouteBean routeBean) {
		if(routeBean!=null)
		{
		String rID = routeBean.getRouteID();
		String src = routeBean.getSource();
		String dst = routeBean.getDestination();
		int dis = routeBean.getDistance();
		double dur = routeBean.getTravelDuration();
		if(rID != null && src!=null && dst != null && dis >0 && dur >0)
		if(src.length()<=20 && rID.matches(src.substring(0, 2)+dst.substring(0, 2)+"(\\d){4}") && dis <=9999 && dur <=999.0)
		{
			isValid = true;
		}
		if(isValid)
		{
			RouteDao routeDao = new RouteDaoImpl();
			return routeDao.updateRoute(routeBean);
		}
		}
		
		return isValid;
	}

	@Override
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate, String source, String destination) {
		ReservationDao rd = new ReservationDaoImpl();
		if(journeyDate!=null && source != null && destination !=null)
		{
			if(source.length()<=30 && destination.length()<=30)
				isValid = true;
		}
		if(isValid)
		return rd.findAllByJourney(journeyDate, source, destination);
		else return null;
	}

}
