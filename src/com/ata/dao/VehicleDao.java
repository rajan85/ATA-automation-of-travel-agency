package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.VehicleBean;

public interface VehicleDao {
	String createVehicle(VehicleBean vehicleBean);
	int deleteVehicle(ArrayList<String> vehicleIDs);
	boolean updateVehicle(VehicleBean vehicleBean);
	VehicleBean findByID(String vehicleID);
	ArrayList<VehicleBean> findAll();
	ArrayList<VehicleBean> findByType(String vehicleType);
	ArrayList<VehicleBean> findBySeats(int noOfSeats);
	public String getVehicleId(String prefix);
}
